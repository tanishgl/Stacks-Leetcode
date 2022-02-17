class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] right = NGEtoRight(temperatures);
        
        for(int i=0;i<temperatures.length;i++){
            temperatures[i] = right[i] - i;
        }
        
        return temperatures;
    }
    
    public int[] NGEtoRight(int[] arr){
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        int[] ans = new int[arr.length];
        ans[ans.length-1] = ans.length-1;
        
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            
            if(st.size()>0){
                ans[i] = st.peek();
            } else {
                ans[i] = i;
            }
            
            st.push(i);
        }
        
        return ans;
    }
}
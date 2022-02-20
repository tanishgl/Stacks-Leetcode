class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] right = new int[s.length()];
        Arrays.fill(right, 0);
        
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch!=c){
                st.push(i);
            } else {
                while(st.size()>0){
                    right[st.peek()] = i - st.pop();
                }
            }
        }
        
        st = new Stack<>();
        st.push(s.length()-1);
        int[] left = new int[s.length()];
        Arrays.fill(left, 0);
        
        for(int i=s.length()-2;i>=0;i--){
            char ch = s.charAt(i);
            
            if(ch!=c){
                st.push(i);
            } else {
                while(st.size()>0){
                    left[st.peek()] = st.pop() - i;
                }
            }
        }
        
        for(int i=0;i<ans.length;i++){
            if(s.charAt(i)==c){
                ans[i] = 0;
            } else {
                ans[i] = (left[i]==0) ? right[i] : ((right[i]==0) ? left[i] : Math.min(left[i],right[i]));
            }
        }
        
        return ans;
    }
}
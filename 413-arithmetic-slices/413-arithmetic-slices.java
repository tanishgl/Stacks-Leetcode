class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        
        int[] diff = new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            diff[i] = nums[i+1] - nums[i];
        }
        
        int count = 0;
        diff = function(diff);
        
        for(int i=0;i<diff.length;i++){
            count += diff[i] - i;
        }
        
        return count;
    }
    
    public int[] function(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i=1;i<arr.length;i++){
            if(st.size()>0 && arr[i]!=arr[st.peek()]){
                int idx = st.peek();
                while(st.size()>0){
                    ans[st.pop()] = idx;
                }
            }
            st.push(i);
        }
        
        int idx = 0;
        if(st.size()>0) idx = st.peek();
        while(st.size()>0){
            ans[st.pop()] = idx;
        }
        
        return ans;
    }
}
class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int[] suffix = new int[nums.length];
        suffix[nums.length-1] = nums[nums.length-1];
        
        for(int i=1;i<nums.length;i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
        
        for(int i=nums.length-2;i>=0;i--){
            suffix[i] = nums[i] + suffix[i+1];
        }
        
        int ans = -1;
        
        int left = 0, right = 0;
        
        for(int i=0;i<nums.length;i++){
            if(i==0) left = 0;
            else left = prefix[i-1];
            
            if(i==nums.length-1) right = 0;
            else right = suffix[i+1];
            
            if(left==right) return i;
        }
        
        return ans;
    }
}
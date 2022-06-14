class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];
        
        if(nums[0] > 0){
            pos[0] = 1;
        } else if (nums[0] < 0){
            neg[0] = 1;
        }
        
        for(int i=1;i<nums.length;i++){
            int val = nums[i];
            
            if(val > 0){
                pos[i] = pos[i-1] + 1;
                if(neg[i-1] > 0)
                    neg[i] = neg[i-1] + 1;
            } else if (val < 0){
                if(neg[i-1] > 0)
                    pos[i] = neg[i-1] + 1;
                neg[i] = pos[i-1] + 1;
            }
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<pos.length;i++){
            ans = Math.max(ans, pos[i]);
        }
        
        return ans;
    }
}
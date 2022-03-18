class Solution {
    public int arraySign(int[] nums) {
        int j = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
                return 0;
            if(nums[i]<0)
                j++;
        }
        
        return (j%2==0) ? 1 : -1;
    }
}
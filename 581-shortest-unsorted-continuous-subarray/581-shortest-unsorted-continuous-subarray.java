class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i = 1;
        while(i<nums.length && nums[i] >= nums[i-1])
            i++;
        if(i==nums.length) return 0;
        int min = nums[i];
        for(int j=i+1;j<nums.length;j++){
            min = Math.min(min, nums[j]);
        }
        for(int j=0;j<i;j++){
            if(nums[j] > min){
                min = j;
                break;
            }
        }
        
        i = nums.length - 2;
        while(i>=0 && nums[i] <= nums[i+1])
            i--;
        int max = nums[i];
        for(int j=0;j<i;j++){
            max = Math.max(nums[j], max);
        }
        for(int j=nums.length-1;j>i;j--){
            if(nums[j]<max){
                max = j;
                break;
            }
        }
        
        return max - min + 1;
        
    }
}
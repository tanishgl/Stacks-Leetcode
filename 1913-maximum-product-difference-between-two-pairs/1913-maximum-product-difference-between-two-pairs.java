class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int ans = 0;
        
        return ((nums[j]*nums[j-1]) - (nums[i]*nums[i+1]));
    }
}
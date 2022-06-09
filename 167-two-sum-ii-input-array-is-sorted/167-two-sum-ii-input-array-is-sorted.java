class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Brute force
        // for(int i=0;i<numbers.length;i++){
        //     for(int j=i+1;j<numbers.length;j++){
        //         if(numbers[i]+numbers[j]==target){
        //             return new int[] {i+1,j+1};
        //         }
        //     }
        // }
        
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==target){
                return new int[] {i+1, j+1};
            } else if (nums[i]+nums[j] > target){
                j--;
            } else if (nums[i] + nums[j] < target){
                i++;
            }
        }
        
        return null;
    }
}
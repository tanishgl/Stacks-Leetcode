class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n-1];
        
        for(int i=1;i<nums.length;i++){
            diff[i-1] = nums[i] - nums[i-1];
        }
        
        int count = 0;
        for(int i=0;i<diff.length;i++){
            int j = i + 1;
            while(j < diff.length && diff[i] == diff[j]){
                count++;
                j++;
            }
        }
        
        return count;
    }
}
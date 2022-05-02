class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        
        int level = -1;
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
            int subject = nums[i];
            if(level < subject){
                level = subject;
            } else {
                level++;
                count += level - subject;
            }
        }
        
        return count;
    }
}
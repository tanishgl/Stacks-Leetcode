class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        int idx = 0;
        while(idx < nums.length && reach >= idx){
            reach = Math.max(idx + nums[idx], reach);
            idx++;
        }
        
        return reach >= nums.length-1;
    }
}
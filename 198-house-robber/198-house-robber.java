class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        mem(nums, 0, dp); 
        return Math.max(dp[0], dp[1]);
    }
    
    public int mem(int[] nums, int house, int[] dp){
        if(house >= nums.length){
            return Integer.MIN_VALUE;
        }
        
        if(house == nums.length-1){
            return nums[house];
        }
        
        if(dp[house]!=-1) return dp[house];
        
        //Either I rob this house.
        int money1 = mem(nums, house + 2, dp);
        money1 = (money1 == Integer.MIN_VALUE) ? nums[house] : money1 + nums[house];
        
        //Or I don't.
        int money2 = mem(nums, house + 1, dp);
        
        dp[house] = Math.max(money1, money2);
        
        return dp[house];
    }
}
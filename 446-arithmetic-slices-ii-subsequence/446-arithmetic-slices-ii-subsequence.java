class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(nums.length < 3) return 0;
        
        HashMap<Long, Long>[] dp = new HashMap[n];
        for(int i=0;i<n;i++){
            dp[i] = new HashMap<>();
        }
        
        long res = 0;
        
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                long cd = 1l * nums[i] - nums[j];
                
                long oldVal = dp[i].getOrDefault(cd, 0l);
                long newVal = oldVal + dp[j].getOrDefault(cd, 0l) + 1l;
                
                dp[i].put(cd, newVal);
                res += dp[j].getOrDefault(cd, 0l);
            }
        }
        
        return (int)res;
    }
}
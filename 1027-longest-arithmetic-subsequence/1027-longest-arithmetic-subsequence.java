class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        int maxL = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            dp[i] = new HashMap<>();
        }
        
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                int cd = nums[i] - nums[j];
                int newVal = dp[j].getOrDefault(cd, 1) + 1;
                // System.out.println(oldVal + " " + newVal);
                dp[i].put(cd, Math.max(newVal, dp[i].getOrDefault(cd, Integer.MIN_VALUE)));
                maxL = Math.max(maxL, dp[i].get(cd));
            }
        }
        
        // for(int i=0;i<n;i++){
        //     System.out.println(dp[i]);
        // }
        
        return maxL;
    }
}
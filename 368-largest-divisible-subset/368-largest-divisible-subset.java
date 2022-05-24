class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        // Sort the array because any permutation of valid subset is also valid.
        Arrays.sort(nums);
        
        List<Integer> res = new ArrayList<>();
        int[] dp = new int[nums.length];
        int[] indices = new int[nums.length];
        Arrays.fill(indices, -1);
        int max = 1, maxIdx = 0;
        
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    indices[i] = j;
                }
            }
            if(dp[i] > max){
                max = Math.max(max, dp[i]);
                maxIdx = i;
            }
        }
        
        while(maxIdx != -1){
            res.add(nums[maxIdx]);
            maxIdx = indices[maxIdx];
        }
        
        return res;
        
        
    }
}
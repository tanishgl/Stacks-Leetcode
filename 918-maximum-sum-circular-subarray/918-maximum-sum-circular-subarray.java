class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        
        int prefSum = nums[0];
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefSum += nums[i];
            prefix[i] = Math.max(prefSum, prefix[i-1]);
        }
        
        int sufSum = nums[n-1];
        int[] suffix = new int[n];
        suffix[n-1] = sufSum;
        for(int i=n-2;i>=0;i--){
            sufSum += nums[i];
            suffix[i] = Math.max(sufSum, suffix[i+1]);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sufSum = (i+1 < n) ? suffix[i+1] : 0;
            max = Math.max(max, prefix[i] + sufSum);
        }
        
        return Math.max(maxSum, max);
    }
}
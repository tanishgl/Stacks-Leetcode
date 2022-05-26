class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0] * 1l;
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        
        long[] suffix = new long[nums.length];
        suffix[n-1] = nums[n-1] * 1l;
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1] + nums[i];
        }
        
        long ans = Long.MAX_VALUE;
        int idx = 0;
        for(int i=0;i<n;i++){
            long a = prefix[i] / (i+1);
            long b = (i < n-1) ? suffix[i+1] / (n-i-1) : 0;
            long avg = Math.abs(a-b);
            if(avg < ans){
                ans = avg;
                idx = i;
            }
        }
        
        return idx;
    }
}
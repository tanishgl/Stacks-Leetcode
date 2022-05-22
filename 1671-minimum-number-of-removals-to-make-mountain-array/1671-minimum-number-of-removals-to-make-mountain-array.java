class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Calculate LIS
        int[] inc = new int[n];
        inc[0] = 1;
        for(int i=1;i<n;i++){
            inc[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[j] < nums[i]) inc[i] = Math.max(inc[i], inc[j] + 1);
            }
        }
        
        // Calculate LDS
        int[] dec = new int[n];
        dec[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            dec[i] = 1;
            for(int j=i+1;j<n;j++){
                if(nums[j] < nums[i]) dec[i] = Math.max(dec[i], dec[j] + 1);
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i=1;i<n-1;i++){
            if(inc[i] >= 2 && dec[i] >= 2){
                max = Math.max(max, inc[i] + dec[i]);
            }
        }
        
        return n - max + 1;
    }
}
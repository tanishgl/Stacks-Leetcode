class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        // LIS subarray
        
        int[] inc = new int[arr.length];
        inc[0] = 1;
        int maxL = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            inc[i] = 1;
            if(arr[i] > arr[i-1]){
                inc[i] = inc[i-1] + 1;
            }
            maxL = Math.max(maxL, inc[i]);
        }
        
        int[] dec = new int[n];
        dec[n-1] = 1;
        int maxR = Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            dec[i] = 1;
            if(arr[i] > arr[i+1]){
                dec[i] = dec[i+1] + 1;
            }
            maxR = Math.max(maxR, dec[i]);
        }
        
        int ans = Integer.MIN_VALUE;
        
        for(int i=1;i<n-1;i++){
            if(inc[i] >= 2 && dec[i] >= 2){
                ans = Math.max(ans, inc[i] + dec[i]);
            }
        }
        
        return (ans == Integer.MIN_VALUE) ? 0 : ans - 1;
        
    }
}
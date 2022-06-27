class Solution {
    int mod = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        
        odd[n-1] = (arr[n-1] % 2 > 0) ? 1 : 0;
        even[n-1] = (odd[n-1] == 0) ? 1 : 0;
        
        for(int i=n-2;i>=0;i--){
            if(arr[i] % 2 == 0){
                even[i] = add(1, even[i+1]);
                odd[i] = odd[i+1];
            } else {
                even[i] = odd[i+1];
                odd[i] = add(1 ,even[i+1]);
            }
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = add(ans, odd[i]);
        }
        
        return ans;
    }
    
    public int add(int a, int b){
        return ((a%mod) + (b%mod)) % mod;
    }
}
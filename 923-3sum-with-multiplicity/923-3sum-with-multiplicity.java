class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long ans = 0;
        int MOD = 1_000_000_007;
        long[] c = new long[101];
        for(int i : arr) c[i]++;  // count occurrences 
        
        for(int i = 0; i < 101; i++) {
            for(int j = i; j < 101; j++) {
                int k = target - i - j;
                if(k < 0 || k > 100) continue;
                if(i == j && j == k) 
                    ans += (c[i] * (c[i] - 1) * (c[i] - 2) / 6); // nC3
                else if(i == j && j != k)  
                    ans += (c[i] * (c[i] - 1) / 2) * c[k]; // (nC2)*(nC1)
                else if(i < j && j < k) 
                    ans += (c[i] * c[j] * c[k]);    // (nC1)(nC1)(nC1)
            }
        }
        return (int)(ans % MOD);
    }
}
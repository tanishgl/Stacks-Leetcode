class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        HashMap<Character, Long> map = new HashMap<>();
        long[] dp = new long[s.length()];
        dp[s.length()-1] = 1l;
        map.put(s.charAt(s.length()-1), 1l);
        
        for(int i=s.length()-2;i>=0;i--){
            char ch = s.charAt(i);
            long start = (1 % mod) + (dp[i+1] % mod) - (map.getOrDefault(ch, 0l) % mod);
            dp[i] = (start % mod) + (dp[i+1] % mod) + mod;
            dp[i] %= mod;
            map.put(ch, (map.getOrDefault(ch,0l) % mod + start % mod));
        }
        
        return (int) dp[0];
    }
}
class Solution {
    public static List<Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
    public long countVowels(String word) {
        int n = word.length();
        long[] dp = new long[n];
        char ch = word.charAt(n-1);
        int count = 1;
        if(vowels.contains(ch)){
            dp[n-1] = 1;
        }
        
        for(int i=n-2;i>=0;i--){
            dp[i] = dp[i+1];
            ch = word.charAt(i);
            if(vowels.contains(ch))
                dp[i] += 1 + count;
            count++;
        }
        
        long ans = 0l;
        for(int i=0;i<dp.length;i++){
            ans += dp[i];
        }
        
        return ans;
    }
}
class Solution {
    public long appealSum(String s) {
        int n = s.length();
        int[] dp = new int[n];
        HashMap<Character, Integer> map = new HashMap<>();
        dp[n-1] = 1;
        map.put(s.charAt(n-1), 1);
        int count = 1;
        
        for(int i=n-2;i>=0;i--){
            dp[i] = 1 + count + dp[i+1];
            if(map.containsKey(s.charAt(i))){
                dp[i] -= map.get(s.charAt(i));
            }
            count++;
            map.put(s.charAt(i), count);
        }
        
        long ans = 0l;
        for(int val : dp)
            ans += val;
        
        return ans;
    }
}
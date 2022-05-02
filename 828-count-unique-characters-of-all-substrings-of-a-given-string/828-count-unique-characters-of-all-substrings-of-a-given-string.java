class Solution {
    public int uniqueLetterString(String s) {
        /* Initialization */
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> delete = new HashMap<>();
        int[] dp = new int[n];
        int count = 1;
        char ch = s.charAt(n-1);
        
        /* Smallest Problem */
        dp[n-1] = 1;
        map.put(ch, 1);
        delete.put(ch, count);
        
        /* Iteration */
        
        for(int i=n-2;i>=0;i--){
            ch = s.charAt(i);
            dp[i] = 1 + dp[i+1];
            int additions = (map.containsKey(ch)) ? count - map.get(ch) : count;
            dp[i] += additions;
            if(delete.containsKey(ch)){
                dp[i] -= delete.get(ch);
            }
            count++;
            map.put(ch, count);
            delete.put(ch, additions + 1);
        }
        
        int sum = 0;
        
        /* Result = sigma(dp[i]) for i = 0 to n-1 */
        
        for(int i=0;i<n;i++){
            // System.out.println(dp[i]);
            sum += dp[i];
        }
            
        
        return sum;
        
    }
}
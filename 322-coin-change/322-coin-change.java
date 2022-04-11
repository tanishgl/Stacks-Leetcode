class Solution {
    public int coinChange(int[] coins, int target) {
        int[] prev = new int[target+1];
        for(int i=1;i<=coins.length;i++){
            int[] curr = new int[target+1];
            curr[0] = 0;
            for(int j=1;j<=target;j++){
                int no = (prev[j] == 0) ? Integer.MAX_VALUE : prev[j];
                int yes = (j - coins[i-1] < 0 || curr[j-coins[i-1]] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : curr[j - coins[i-1]] + 1;
                curr[j] = Math.min(no, yes);
            }
            
            for(int j=0;j<=target;j++){
                prev[j] = curr[j];
            }
        }
        
        return (prev[target] == Integer.MAX_VALUE) ? -1 : prev[target];
    }
}
class Solution {
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount+1];
        for(int i=1;i<=coins.length;i++){
            int[] curr = new int[amount+1];
            curr[0] = 1;
            for(int j=1;j<=amount;j++){
                int no = prev[j];
                int yes = (j - coins[i-1] >= 0) ? curr[j - coins[i-1]] : 0;
                curr[j] = no + yes;
            }
            
            for(int j=0;j<prev.length;j++){
                prev[j] = curr[j];
            }
        }
        
        return prev[prev.length-1];
    }
}
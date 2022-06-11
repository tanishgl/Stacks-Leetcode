class Solution {
    public int climbStairs(int n) {
    
        int adv = 1;
        int bas = 1;
        
        for(int i=n-2;i>=0;i--){
            int ways = bas + adv;
            adv = bas;
            bas = ways;
        }
        
        return bas;
    }
}
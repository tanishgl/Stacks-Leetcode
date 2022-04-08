class Solution {
    public int twoEggDrop(int n) {
        int ans = 0, i = 1;
        while(n>0){
            ans++;
            n -= i;
            i++;
        }
        
        return ans;
    }
}
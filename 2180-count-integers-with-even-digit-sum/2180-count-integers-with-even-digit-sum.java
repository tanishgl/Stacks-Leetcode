class Solution {
    public int countEven(int num) {
        int ans = 0;
        while(num>0){
            if(sum(num)%2==0)
                ans++;
            num--;
        }
        
        return ans;
    }
    
    public static int sum(int n){
        int ans = 0;
        while(n>0){
            int rem = n%10;
            ans += rem;
            n/=10;
        }
        
        return ans;
    }
}
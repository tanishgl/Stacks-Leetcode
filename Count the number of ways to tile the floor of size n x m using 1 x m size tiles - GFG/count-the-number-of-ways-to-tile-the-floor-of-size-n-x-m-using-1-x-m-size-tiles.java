// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String [] S = s.split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.countWays(n, m);
            System.out.println(ans);         
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    static int mod = 1000000007;
    public int countWays(int n, int m)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        mem(dp, n, m);
        return dp[n];
    }
    
    public int mem(int[] dp, int h, int v){
        //System.out.println(h + " " + v);
        if(h<v){
            return dp[h] = 1;
        }
        
        if(h==v){
            return dp[h] = 2;
        }
        
        if(dp[h] != -1) return dp[h];
        
        int ans = 0;
        int ans1 = mem(dp, h-1, v);
        int ans2 = mem(dp, h-v, v);
        dp[h] = (ans1 + ans2) % mod;
        return dp[h];
    }
}
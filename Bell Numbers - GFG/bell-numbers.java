// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            
            Solution obj = new Solution();
            int ans = obj.bellNumber(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
    int bellNumber(int N){
        long mod = 1000000007;
        long ans = 0l;
        long[][] dp = new long[N+1][N+1];
        for(int i=0;i<=N;i++){
            Arrays.fill(dp[i], -1);
        }
        for(int k=1;k<=N;k++){
            ans += partition(N, k, dp) % mod;
        }
        
        return (int)(ans % mod);
    }
    
    long partition(int n, int k, long[][] dp){
        if(n < k || k == 0) return 0l;
        if(n == k) return 1l;
        if(dp[n][k] != -1) return dp[n][k];
        
        return dp[n][k] = add(multiply(k, partition(n-1,k,dp)), partition(n-1,k-1,dp));
    }
    
    long multiply(long a, long b){
        long mod = 1000000007;
        return ((a % mod) * (b % mod)) % mod;
    }
    
    long add(long a, long b){
        long mod = 1000000007;
        return ((a % mod) + (b % mod)) % mod;
    }
    
}
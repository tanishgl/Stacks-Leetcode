// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[n][m];
        
        for(int j=m-1;j>=0;j--){
            for(int i=n-1;i>=0;i--){
                int du = (i-1 >=0 && j+1 < m) ? dp[i-1][j+1] : Integer.MIN_VALUE;
                int ds = (j+1 < m) ? dp[i][j+1] : Integer.MIN_VALUE;
                int dd = (i+1 < n && j+1 < m) ? dp[i+1][j+1] : Integer.MIN_VALUE;
                int gold = Math.max(du, Math.max(ds, dd));
                dp[i][j] = (gold == Integer.MIN_VALUE) ? M[i][j] : gold + M[i][j];
            }
        }
        
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[i][0]);
        }
        
        return ans;
    }
}
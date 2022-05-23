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
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[] dp = new int[W+1];
        dp[0] = 0;
        
        // for(int i=1;i<=W;i++){
        //     for(int j=0;j<N;j++){
        //         if(i-wt[j]>=0){
        //             dp[i] = Math.max(dp[i], val[j] + dp[i-wt[j]]);
        //         }
        //     }
        // }
        
        for(int i=0;i<N;i++){
            for(int j=1;j<=W;j++){
                dp[j] = (j-wt[i]>=0) ? Math.max(dp[j], val[i] + dp[j-wt[i]]) : dp[j];
            }
        }
        
        return dp[W];
    }
    
    
}
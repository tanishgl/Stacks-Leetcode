// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp = new int[N][N];
        // for(int i=0;i<N;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // return partition(arr, 0, arr.length-2, dp);
        
        for(int gap=1;gap<N-1;gap++){
            for(int l=0,r=gap; r<N-1; l++, r++){
                int minCost = Integer.MAX_VALUE;
                for(int k=l;k<r;k++){
                    int left = dp[l][k];
                    int right = dp[k+1][r];
                    int cost = left + right + (arr[l] * arr[k+1] * arr[r+1]);
                    minCost = Math.min(minCost, cost);
                }
                
                dp[l][r] = minCost;
            }
        }
        
        return dp[0][N-2];
    }
    
    static int partition(int[] arr, int l, int r, int[][] dp){
        if(l == r){
            return 0;
        }
        
        if(dp[l][r] != -1) return dp[l][r];
        
        int minCost = Integer.MAX_VALUE;
        
        // Creating partitions.
        for(int i=l;i<r;i++){
            int left = partition(arr, l, i, dp);
            int right = partition(arr, i + 1, r, dp);
            int cost = left + right + arr[l] * arr[i+1] * arr[r+1];
            minCost = Math.min(minCost, cost);
        }
        
        return dp[l][r] = minCost;
    }
}
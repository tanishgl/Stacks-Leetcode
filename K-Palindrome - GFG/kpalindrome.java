// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int kPalindrome(String str, int n, int k)
    {
        // code here
        int[][] dp = new int[n+1][n+1];
        
        String rev = new StringBuilder(str).reverse().toString();
        
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                char ch1 = str.charAt(i);
                char ch2 = rev.charAt(j);
                
                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        return ((str.length() - dp[0][0]) <= k) ? 1 : 0;
    }
}
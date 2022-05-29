// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int N) {
        // code here
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        int len = 0, idx = s.length();
        
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s.charAt(i) == s.charAt(j) && i!=j){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                
                if(Math.min(i,j) + dp[i][j] >= Math.max(i,j)){
                    // Overlapping substrings.
                    dp[i][j] = 0;
                }
                
                if(dp[i][j] >= len){
                    len = dp[i][j];
                    idx = i;
                }
            }
        }
        
        // System.out.println(len + " " + idx);
        String res = s.substring(idx, idx + len);
        
        if(len == 0) return "-1";
        return res;
    }
};
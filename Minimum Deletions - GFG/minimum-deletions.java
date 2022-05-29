// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String s) {
        //your code here
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String p = sb.reverse().toString();
        int[][] dp = new int[n+1][n+1];
        
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                char ch = s.charAt(i);
                char ch2 = p.charAt(j);
                if(ch == ch2){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        return s.length() - dp[0][0];
    }
}
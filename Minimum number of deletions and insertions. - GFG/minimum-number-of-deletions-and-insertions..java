// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n = str1.length(), m = str2.length();
	    int[][] dp = new int[n+1][m+1];
	    
	    for(int i=n-1;i>=0;i--){
	        for(int j=m-1;j>=0;j--){
	            char ch1 = str1.charAt(i);
	            char ch2 = str2.charAt(j);
	            
	            if(ch1 == ch2){
	                dp[i][j] = dp[i+1][j+1] + 1;
	            } else {
	                dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
	            }
	        }
	    }
	    
	    int lcs = dp[0][0];
	    
	    return str1.length() + str2.length() - 2 * lcs;
	} 
}
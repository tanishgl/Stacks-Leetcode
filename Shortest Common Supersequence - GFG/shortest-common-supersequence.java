// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        int[][] dp = new int[m+1][n+1];
        
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                char ch1 = X.charAt(i);
                char ch2 = Y.charAt(j);
                
                if(ch1 == ch2){
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        return m + n - dp[0][0];
    }
}
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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minSteps(n));
                    
                }
        }
}    // } Driver Code Ends


class Solution{

	public int minSteps(int N) 
	{ 
	    
	    if(N==1) return 0;
	    if(N==2 || N==3) return 1;
	    int[] dp = new int[N+1];
	    dp[0] = 0;
	    dp[1] = 1;
	    dp[2] = 1;
	    dp[3] = 1;
	    for(int i=4;i<=N;i++){
	        int x = (i%2==0) ? dp[i/2] : Integer.MAX_VALUE;
	        int y = (i%3==0) ? dp[i/3] : Integer.MAX_VALUE;
	        dp[i] = Math.min(dp[i-1], Math.min(x,y));
	        if(dp[i]!=Integer.MAX_VALUE) dp[i]++;
	    }
	    
	    
	    return dp[N];
	} 
}

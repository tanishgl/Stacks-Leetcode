// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}


// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int[][] dp = new int[k+1][n+1];
	    for(int i=0;i<=k;i++){
	        Arrays.fill(dp[i], -1);
	    }
	    return helper(k, n, dp);
	}
	
	static int helper(int floors, int eggs, int[][] dp){
	    if(floors == 0) return 0;
	    if(eggs == 1) return floors;
	    
	    if(dp[floors][eggs] != -1) return dp[floors][eggs];
	    
	    int min = floors;
	    
	    for(int i=1;i<=floors;i++){
	        min = Math.min(min, Math.max( helper(i - 1, eggs - 1, dp), helper(floors - i, eggs, dp) ));
	    }
	    
	    return dp[floors][eggs] = min + 1;
	}
}
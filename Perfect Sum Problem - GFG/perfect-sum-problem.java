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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int mod = 1000000007;
	    int[] prev = new int[sum+1];
	    prev[0] = 1;
	    
	    for(int i=1;i<=n;i++){
	        int[] curr = new int[sum+1];
	        for(int j=0;j<=sum;j++){
	            int no = prev[j];
	            int yes = (j - arr[i-1] >= 0) ? prev[j - arr[i-1]] : 0;
	            curr[j] = (no + yes) % mod;
	        }
	        
	        for(int j=0;j<prev.length;j++){
	            prev[j] = curr[j];
	        }
	    }
	    
	    return prev[sum] % mod;
	} 
}
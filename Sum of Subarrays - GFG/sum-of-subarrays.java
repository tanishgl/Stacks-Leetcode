// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.subarraySum(a, n));
        }
	}
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public static long mod = 1000000007l;
    
    public static long subarraySum( long a[], long n) {
       // code here  
       long ans = 0l;
       for(int i=0;i<n;i++){
           long element = a[i] * 1l;
           long x = mul(n-i, i+1);
           x = mul(x, element);
           ans = add(ans, x);
       }
       return ans;
    }
    
    public static long add(long a, long b){
        return ((a%mod) + (b%mod)) % mod;
    }
    
    public static long mul(long a, long b){
        return ((a%mod) * (b%mod)) % mod;
    }
}

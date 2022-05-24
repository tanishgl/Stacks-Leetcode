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
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumBS(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java



class Compute {
    
    public static int maxSumBS(int arr[], int n)
    {
        int[] inc = new int[n];
        
        for(int i=0;i<n;i++){
            inc[i] = arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[i] > arr[j]){
                    inc[i] = Math.max(arr[i] + inc[j], inc[i]);
                }
            }
        }
        
        int[] dec = new int[n];
        
        for(int i=n-1;i>=0;i--){
            dec[i] = arr[i];
            for(int j=i+1;j<n;j++){
                if(arr[i] > arr[j]){
                    dec[i] = Math.max(dec[i], arr[i] + dec[j]);
                }
            }
        }
        
        // for(int i=1;i<n-1;i++){
        //     System.out.println(inc[i] + " " + dec[i]);
        // }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, inc[i] + dec[i] - arr[i]);
        }
        
        return ans;
    }
}
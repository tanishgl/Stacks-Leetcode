// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}


// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        int curr = 0, maxS = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            curr = Math.max(curr + a[i], a[i]);
            maxS = Math.max(maxS, curr);
        }
        
        int prefixSum = a[0];
        int[] prefix = new int[n];
        prefix[0] = prefixSum;
        
        for(int i=1;i<n;i++){
            prefixSum += a[i];
            prefix[i] = Math.max(prefix[i-1], prefixSum);
        }
        
        int suffixSum = a[n-1];
        int[] suffix = new int[n];
        suffix[n-1] = suffixSum;
        
        for(int i=n-2;i>=0;i--){
            suffixSum += a[i];
            suffix[i] = Math.max(suffix[i+1], suffixSum);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            suffixSum = (i+1 < n) ? suffix[i+1] : 0;
            max = Math.max(max, prefix[i] + suffixSum);
        }
        
        return Math.max(maxS, max);
    }
    
}


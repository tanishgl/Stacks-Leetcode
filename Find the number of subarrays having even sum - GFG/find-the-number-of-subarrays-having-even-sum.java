// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            long ans = new Solution().countEvenSum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    long countEvenSum(int[] arr, int n) {
        // code here
        long[] odd = new long[n];
        long[] even = new long[n];
        odd[n-1] = (arr[n-1] % 2 > 0) ? 1 : 0;
        even[n-1] = (odd[n-1] == 0) ? 1 : 0;
        
        for(int i=n-2;i>=0;i--){
            if(arr[i] % 2 == 0){
                even[i] = 1 + even[i+1];
                odd[i] = odd[i+1];
            } else {
                even[i] = odd[i+1];
                odd[i] = 1 + even[i+1];
            }
        }
        
        long ans = 0l;
        for(int i=0;i<n;i++){
            ans += even[i];
        }
        return ans;
    }
}

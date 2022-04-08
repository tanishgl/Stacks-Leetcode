// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[] prev = new int[sum+1];
        for(int i=1;i<=N;i++){
            int[] curr = new int[sum+1];
            prev[0] = curr[0] = 1;
            for(int j=1;j<=sum;j++){
                int yes = (j - arr[i-1] >= 0) ? prev[j-arr[i-1]] : 0;
                int no = prev[j];
                if(yes ==1 || no == 1){
                    curr[j] = 1;
                } else {
                    curr[j] = 0;
                }
            }
            
            for(int j=0;j<=sum;j++){
                prev[j] = curr[j];
            }
        }
        
        return prev[sum] == 1;
    }
}
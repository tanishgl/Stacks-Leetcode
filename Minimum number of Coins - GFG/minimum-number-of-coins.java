// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int[] deno = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
    static List<Integer> minPartition(int N)
    {
        // code here
        List<Integer> res = new ArrayList<>();
        for(int i=deno.length-1;i>=0;i--){
            int x = N / deno[i];
            N = N - (x * deno[i]);
            for(int j=0;j<x;j++){
                res.add(deno[i]);
            }
        }
        
        return res;
    }
}
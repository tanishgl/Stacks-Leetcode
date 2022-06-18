// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        if(r > n) return 0;
        if(r == 0 || r == n || r == 0) return 1;
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        
        for(int i=1;i<=n;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            
            for(int j=1;j<i;j++){
                row.add((prev.get(j) + prev.get(j-1)) % 1000000007);
            }
            
            row.add(1);
            
            prev = row;
        }
        
        return prev.get(r);
    }
}
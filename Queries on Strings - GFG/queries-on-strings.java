// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            int q = Integer.parseInt(br.readLine().trim());
            int[][] Query = new int[q][2];
            for(int i = 0; i < q; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    Query[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.SolveQueris(str, Query);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] SolveQueris(String str, int[][] Query)
    {
        int[] freq = new int[26];
        int[] ans = new int[Query.length];
        for(int i=0;i<Query.length;i++){
            int l = Query[i][0]-1;
            int r = Query[i][1]-1;
            
            int count = 0;
            for(int j=l;j<=r;j++){
                char ch = str.charAt(j);
                freq[ch-'a']++;
                if(freq[ch-'a']==1) count++;
            }
            ans[i] = count;
            Arrays.fill(freq, 0);
        }
        
        return ans;
    }
}
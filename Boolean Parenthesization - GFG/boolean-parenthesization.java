// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countWays(int N, String S){
        // code here
        int[][][] dp = new int[N+1][N+1][2];
        for(int i=0;i<=N;i++){
            for(int j=0;j<N;j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        
        return memo(S, 0, N-1, dp)[0];
    }
    
    static int[] memo(String s, int left, int right, int[][][] dp){
        if(left == right){
            if(s.charAt(left) == 'T') return new int[]{1, 0};
            return new int[]{0,1};
        }
        
        if(dp[left][right][0] != -1) return dp[left][right];
        
        int[] res = {0, 0};
        
        for(int i=left+1;i<right;i+=2){
            int[] l = memo(s, left, i - 1, dp);
            int[] r = memo(s, i + 1, right, dp);
            int[] ans = eval(l, r, s.charAt(i));
            res[0] = (res[0] + ans[0]) % 1003;
            res[1] = (res[1] + ans[1]) % 1003;
        }
        
        return dp[left][right] = res;
    }
    
    static int[] eval (int[] l, int[] r, char opt){
        long[] curr = {0,0};
        if(opt == '&'){
            curr[0] = l[0] * r[0];
            curr[1] = l[0] * r[1] + l[1] * r[0] + l[1] * r[1];
        } else if (opt == '|'){
            curr[0] = l[0] * r[1] + l[1] * r[0] + l[0] * r[0];
            curr[1] = l[1] * r[1];
        } else if (opt == '^'){
            curr[0] = l[0] * r[1] + l[1] * r[0];
            curr[1] = l[0] * r[0] + l[1] * r[1];
        }
        
        curr[0] = curr[0] % 1003;
        curr[1] = curr[1] % 1003;
        
        return new int[]{(int)curr[0], (int)curr[1]};
    }
}
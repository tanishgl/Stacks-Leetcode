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
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    public long countFriendsPairings(int n) 
    { 
       long mod = 1000000007;
       long p1 = 1;
       long p2 = 2;
       if(n==1) return 1;
       if(n==2) return 2;
       
       for(int i=3;i<=n;i++){
           long single = ((1 % mod) * (p2 % mod)) % mod;
           long pair = (((i-1) % mod) * (p1 % mod)) % mod;
           long ways = (single + pair) % mod;
           p1 = p2;
           p2 = ways;
       }
       
       return p2 % mod;
    }
}    
 
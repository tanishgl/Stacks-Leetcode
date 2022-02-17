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
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        Stack<Integer> st = new Stack<>();
        int ans = Integer.MIN_VALUE;
        
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            
            if(ch=='('){
                st.push(i);
            } else {
                if(st.size()>0 && S.charAt(st.peek())=='('){
                    st.pop();
                } else {
                    st.push(i);
                }
            }
            
            //idx is index after which the string is valid.
            int idx = (st.size()>0) ? st.peek() : -1;
            ans = Math.max(ans, i - idx);
        }
        
        return ans;
    }
}
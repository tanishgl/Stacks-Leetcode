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
        int ans = 0 , open = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(ch=='('){
                open++;
                st.push(i);
            } else {
                if(open>0){
                    open--;
                    st.pop();
                } else {
                    st.push(i);
                }
            }
            
            int now_length = (st.size()==0) ? (i+1) : (i-st.peek());
            ans = Math.max(now_length, ans);
        }
        
        return ans;
    }
}
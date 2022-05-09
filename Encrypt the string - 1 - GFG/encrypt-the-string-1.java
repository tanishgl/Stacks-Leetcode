// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.encryptString(s));
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String encryptString(String s) 
    {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(i>0 && ch!=s.charAt(i-1)){
                sb.append(count+"");
                sb.append(ch);
                count = 0;
            }
            count++;
        }
        
        sb.append(count);
        return sb.reverse().toString();
        
    }
} 
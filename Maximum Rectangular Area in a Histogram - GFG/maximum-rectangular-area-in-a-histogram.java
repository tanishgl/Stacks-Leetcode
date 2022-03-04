// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        long[] nsl = NSL(hist);
        long[] nsr = NSR(hist);
        long ans = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            ans = Math.max(ans, (nsr[i]-nsl[i]-1)*hist[i]);
        }
        
        return ans;
    }
    
    public static long[] NSL(long[] arr){
        long[] ans = new long[arr.length];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            if(st.size()>0){
                ans[i] = st.peek();
            }
            
            st.push(i);
        }
        
        return ans;
    }
    
    public static long[] NSR(long[] arr){
        long[] ans = new long[arr.length];
        Arrays.fill(ans, arr.length);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[i]<arr[st.peek()]){
                ans[st.pop()] = i;
            }
            
            st.push(i);
        }
        
        return ans;
    }
        
}




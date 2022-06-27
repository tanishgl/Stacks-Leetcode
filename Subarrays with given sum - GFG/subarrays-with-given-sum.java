// { Driver Code Starts
import java.util.*; 
import java.lang.*;
import java.io.*;




class Array
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0)
	    {
	    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i] = sc.nextInt();
		    }
		    int sum = sc.nextInt();
		    Solution ob=new Solution();
		    System.out.println(ob.subArraySum(arr,n,sum));
		}
	}
}

// } Driver Code Ends


class Solution
{ 
    public static int subArraySum(int[] arr, int n, int sum)
    { 
        //code here.
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            int target = prefix[i] - sum;
            if(map.containsKey(target)){
                count += map.get(target);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }
        
        return count;
    }
}
  
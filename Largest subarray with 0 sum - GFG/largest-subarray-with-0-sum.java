// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int target = prefix[i] - 0;
            if(map.containsKey(target)){
                maxLen = Math.max(maxLen, i - map.get(target));
                // System.out.println(i + " " + map.get(target));
            }
            if(!map.containsKey(target)) map.put(prefix[i],i);
        }
        
        return (maxLen != Integer.MIN_VALUE) ? maxLen : 0;
    }
}
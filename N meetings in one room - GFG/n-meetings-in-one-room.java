// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution 
{
    
    static class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public static class MyComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2){
            return i1.end - i2.end;
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        Interval[] intervals = new Interval[start.length];
        for(int i=0;i<start.length;i++){
            intervals[i] = new Interval(start[i], end[i]);
        }
        
        Arrays.sort(intervals, new MyComparator());
        
        int count = 0;
        int limit = Integer.MIN_VALUE;
        
        for(int i=0;i<intervals.length;i++){
            if(intervals[i].start <= limit){
                //Overlapping.
            } else {
                count++;
                limit = intervals[i].end;
            }
        }
        
        return count;
    }
}

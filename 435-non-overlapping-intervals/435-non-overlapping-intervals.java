class Solution {
    public class Interval {
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public class MyComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2){
            return i1.end - i2.end;
        }
    }
    
    public int eraseOverlapIntervals(int[][] nums) {
        Interval[] intervals = new Interval[nums.length];
        
        for(int i=0;i<intervals.length;i++){
            intervals[i] = new Interval(nums[i][0], nums[i][1]);
        }
        
        Arrays.sort(intervals, new MyComparator());
        
        int count = 0;
        int limit = Integer.MIN_VALUE;
        
        for(int i=0;i<intervals.length;i++){
            if(intervals[i].start < limit){
                count++;
            } else {
                limit = intervals[i].end;
            }
        }
        
        return count;
    }
}
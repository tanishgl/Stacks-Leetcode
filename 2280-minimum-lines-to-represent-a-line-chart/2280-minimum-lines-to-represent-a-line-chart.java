class Solution {
    public int minimumLines(int[][] arr) {
        if(arr.length < 2)
            return 0;
        
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        int count = 1;
        for(int i=2;i<arr.length;i++){
            int[] p1 = arr[i-2];
            int[] p2 = arr[i-1];
            int[] p3 = arr[i];
            if((long) (p2[1] - p1[1]) * (p3[0] - p2[0]) != (long) (p3[1] - p2[1]) * (p2[0] - p1[0]))
                count++;
        }
        
        return count;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        
        int[][] ans = new int[k][2];
        
        for(int[] arr : points){
            pq.add(arr);
            if(pq.size() > k)
                pq.remove();
        }
        
        int count = 0;
        while(pq.size()>0){
            ans[count++] = pq.remove();
        }
        
        return ans;
    }
}

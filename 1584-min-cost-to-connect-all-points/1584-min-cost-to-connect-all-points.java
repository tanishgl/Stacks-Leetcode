class Solution {
    
    public static class Pair{
        int wt, idx;
        Pair(int wt, int idx){
            this.wt = wt;
            this.idx = idx;
        }
        
    }
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.add(new Pair(0, 0));
        boolean[] vis = new boolean[n];
        
        int count = 0, cost = 0;
        
        while(pq.size()>0 && count < points.length){
            Pair curr = pq.remove();
            if(vis[curr.idx]) continue;
            vis[curr.idx] = true;
            cost += curr.wt;
            count++;
            for(int i=0;i<n;i++){
                if(i == curr.idx) continue;
                int dist = Math.abs(points[curr.idx][0] - points[i][0]) + Math.abs(points[curr.idx][1] - points[i][1]);
                pq.add(new Pair(dist, i));
            }
        }
        
        return cost;
    }
}
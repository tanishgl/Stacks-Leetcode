class Solution {
    
    public static class Pair{
        int node;
        int cost;
        
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : times){
            adj[edge[0] - 1].add(new Pair(edge[1] - 1, edge[2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Pair(k - 1, 0));
        int[] vis = new int[n];
        Arrays.fill(vis, Integer.MAX_VALUE);
        
        while(pq.size()>0){
            Pair front = pq.remove();
            if(vis[front.node] != Integer.MAX_VALUE) continue;
            vis[front.node] = front.cost;
            
            for(Pair nbr : adj[front.node]){
                pq.add(new Pair(nbr.node, nbr.cost + front.cost));
            }
        }
        
        int time = vis[k-1];
        for(int i=0;i<n;i++){
            time = Math.max(time, vis[i]);
        }
        
        return (time == Integer.MAX_VALUE) ? -1 : time;
    }
}
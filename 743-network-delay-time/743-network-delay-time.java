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
            adj[edge[0]-1].add(new Pair(edge[1]-1, edge[2]));
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        q.add(new Pair(k-1, 0));
        int[] vis = new int[n];
        Arrays.fill(vis, Integer.MAX_VALUE);
        
        while(q.size()>0){
            Pair curr = q.remove();
            
            if(vis[curr.node] != Integer.MAX_VALUE) continue;
            vis[curr.node] = curr.cost;
            
            for(Pair nbr : adj[curr.node]){
                q.add(new Pair(nbr.node, curr.cost + nbr.cost));
            }
        }
        
        int time = 0;
        for(int i=0;i<n;i++){
            if(vis[i] == Integer.MAX_VALUE) return -1;
            time = Math.max(time, vis[i]);
        }
        
        return time;
    }
}
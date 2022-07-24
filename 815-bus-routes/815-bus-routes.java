class Solution {
    
    public static class Pair{
        int node;
        int color;
        int change;
        
        Pair(int node, int color, int change){
            this.node = node;
            this.color = color;
            this.change = change;
        }
    }
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = 0;
        for(int[] route : routes)
            for(int stop : route)
                n = Math.max(n, stop);
        
        ArrayList<Pair>[] adj = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            adj[i] = new ArrayList<>();
        
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                int src = routes[i][j];
                int dest = routes[i][(j+1)%routes[i].length];
                
                adj[src].add(new Pair(dest, i, 0));
                adj[dest].add(new Pair(src, i, 0));
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.change - b.change);
        pq.add(new Pair(source, routes.length, 0));
        
        int[][] vis = new int[n+1][routes.length+1];
        for(int i=0;i<vis.length;i++){
            Arrays.fill(vis[i], -1);
        }
        
        while(pq.size()>0){
            Pair curr = pq.remove();
            
            if(curr.node == target) return curr.change;
            
            if(vis[curr.node][curr.color] != -1) continue;
            vis[curr.node][curr.color] = curr.change;
            
            for(Pair nbr : adj[curr.node]){
                if(curr.color == nbr.color){
                    pq.add(new Pair(nbr.node, nbr.color, curr.change));
                } else {
                    pq.add(new Pair(nbr.node, nbr.color, curr.change + 1));
                }
            }
        }
        
        return -1;
    }
}
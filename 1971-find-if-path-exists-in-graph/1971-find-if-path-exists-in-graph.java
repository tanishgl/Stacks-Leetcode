class Graph{
        ArrayList<Integer>[] adj;
        
        Graph(int n){
            adj = new ArrayList[n];
            for(int i=0;i<n;i++){
                adj[i] = new ArrayList<>();
            }
        }
        
        //unweighted array
        public void addEdge(int src, int dest){
            adj[src].add(dest);
            adj[dest].add(src);
        }
    }

class Solution {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n);
        
        for(int i=0;i<edges.length;i++){
            g.addEdge(edges[i][0], edges[i][1]);
        }
        
        boolean[] vis = new boolean[n];
        
        return helper(vis, g.adj, source, destination);
    }
    
    public boolean helper(boolean[] vis, ArrayList<Integer>[] adj, int src, int dest){ 
        if(src == dest)
            return true;
        if(vis[src])
            return false;
        
        vis[src] = true;
        
        for(int neighbour : adj[src]){
            if(helper(vis, adj, neighbour, dest))
                return true;
        }
        
        return false;
    }
}
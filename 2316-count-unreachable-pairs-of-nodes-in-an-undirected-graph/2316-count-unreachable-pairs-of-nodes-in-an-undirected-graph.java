class Graph{
    ArrayList<Integer>[] adj;
    
    Graph(int n){
        adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }
    
    public void DFS(int src, boolean[] vis, List<Integer> path){
        if(vis[src]) return;
        vis[src] = true;
        path.add(src);
        for(int nbr : adj[src]){
            DFS(nbr, vis, path);
        }
    }
}

class Solution {
    public long countPairs(int n, int[][] edges) {
        Graph g = new Graph(n);
        for(int i=0;i<edges.length;i++){
            g.addEdge(edges[i][0], edges[i][1]);
        }
        
        boolean[] vis = new boolean[n];
        long pairs = 0l;
        for(int i=0;i<n;i++){
            if(vis[i] == false){
                List<Integer> component = new ArrayList<>();
                g.DFS(i, vis, component);
                pairs = pairs + ((component.size()) * ((n * 1l) - component.size()));
            }
        }
                                  
        return pairs / 2l;                    
                                 
    }
}
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
    
    public void DFS(int src, boolean[] vis){
        if(vis[src]) return;
        
        vis[src] = true;
        for(int nbr : adj[src])
            DFS(nbr, vis);
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        Graph g = new Graph(n);
        for(int i=0;i<connections.length;i++){
            g.addEdge(connections[i][0], connections[i][1]);
        }
        
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                g.DFS(i, vis);
            }
        }
        
        return count - 1;
    }
}
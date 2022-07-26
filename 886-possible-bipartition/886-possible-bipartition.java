class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            adj[i] = new ArrayList<>();
        for(int[] edge : dislikes){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        int[] vis = new int[n+1];
        Arrays.fill(vis, -1);
        
        for(int i=1;i<=n;i++){
            if(vis[i] == -1 && !DFS(i, adj, vis, 0))
                return false;
        }
        
        return true;
    }
    
    public boolean DFS(int src, ArrayList<Integer>[] adj, int[] vis, int color){
        color %= 2;
        if(vis[src] != -1){
            return vis[src] == color;
        }
        
        vis[src] = color;
        for(int nbr : adj[src]){
            if(!DFS(nbr, adj, vis, color + 1))
                return false;
        }
        
        return true;
    }
}
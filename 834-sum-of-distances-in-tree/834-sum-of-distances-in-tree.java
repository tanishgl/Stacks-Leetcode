class Solution {
    
    int[] size, ans;
    
    public void subtree(int src, int par, ArrayList<Integer>[] adj){
        for(Integer nbr : adj[src]){
            if(par == nbr) continue;
            subtree(nbr, src, adj);
            ans[src] += (ans[nbr] + size[nbr]);
            size[src] += size[nbr];
        }
    }
    
    public void DFS(int src, int par, ArrayList<Integer>[] adj){
        if(par != -1){
            ans[src] = ans[par] + adj.length - 2 * size[src];
        }
        
        for(Integer nbr : adj[src]){
            if(nbr == par) continue;
            DFS(nbr, src, adj);
        }
    }
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        size = new int[n];
        ans = new int[n];
        Arrays.fill(size, 1);
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i] = new ArrayList<>();
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        subtree(0, -1, adj);
        DFS(0, -1, adj);
        return ans;
    }
}
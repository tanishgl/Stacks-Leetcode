class Graph{
    ArrayList<Integer>[] adj;
    int[] inc;
    
    Graph(int n){
        adj = new ArrayList[n];
        inc = new int[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest){
        adj[src].add(dest);
        inc[dest]++;
    }
    
    public int[] topologicalSorting(int n){
        int[] sort = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(inc[i] == 0) q.add(i);
        }
        
        boolean[] vis = new boolean[n];
        int idx = 0;
        
        while(q.size()>0){
            int node = q.remove();
            if(vis[node]) continue;
            vis[node] = true;
            sort[idx++] = node;
            for(int nbr : adj[node]){
                inc[nbr]--;
                if(inc[nbr] == 0)
                    q.add(nbr);
            }
        }
        
        return sort;
    }
}

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Graph g = new Graph(n);
        for(int[] edge : richer){
            g.addEdge(edge[1], edge[0]);
        }
        
        int[] sort = g.topologicalSorting(n);
        
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = i;
        }
        
        for(int i=n-1;i>=0;i--){
            int poor = sort[i];
            for(int j=i+1;j<n;j++){
                int rich = sort[j];
                if(!g.adj[poor].contains(rich)) continue;
                if(quiet[ans[rich]] < quiet[ans[poor]])
                    ans[poor] = ans[rich];
            }
        }
        
        return ans;
    }
}
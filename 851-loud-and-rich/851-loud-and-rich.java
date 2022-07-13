class Graph{
    ArrayList<Integer>[] adj;
    
    Graph(int n){
        this.adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest){
        adj[src].add(dest);
    }
    
    public int[] topo(int n){
        int[] inc = new int[n];
        for(int i=0;i<n;i++){
            for(int nbr : adj[i]){
                inc[nbr]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(inc[i] == 0) q.add(i);
        }
        
        int[] ans = new int[n];
        int idx = 0;
        
        while(q.size()>0){
            int p = q.remove();
            ans[idx++] = p;
            for(int nbr : adj[p]){
                inc[nbr]--;
                if(inc[nbr] == 0) q.add(nbr);
            }
        }
        
        return ans;
    }
}

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Graph g = new Graph(n);
        
        for(int[] edge : richer){
            g.addEdge(edge[1], edge[0]);
        }
        
        int[] sorted = g.topo(n);
        
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = i;
        }
        
        for(int i=n-1;i>=0;i--){
            int node = sorted[i];
            // System.out.println(node);
            for(int j=i+1;j<n;j++){
                if(g.adj[node].contains(sorted[j]) && quiet[ans[sorted[j]]] < quiet[ans[node]]){
                    ans[node] = ans[sorted[j]];
                    // System.out.print(node + " -> " + sorted[j] + " ");
                }
            }
            // System.out.println();
            // System.out.println(node + " " + ans[node]);
        }
        
        return ans;
    }
}
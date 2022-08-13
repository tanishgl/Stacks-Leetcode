class Solution {
    
    class DSU{
        int[] parent, rank;
        
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }
        
        public int find(int x){
            if(parent[x] == -1) return x;
            return parent[x] = find(parent[x]);
        }
        
        public void union(int a, int b){
            a = find(a);
            b = find(b);
            if(a == b) return;
            if(rank[a] >= rank[b]){
                parent[b] = a;
                rank[a] += rank[b];
            } else {
                parent[a] = b;
                rank[b] += rank[a];
            }
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU sets = new DSU(n+1);
        
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(sets.find(a) == sets.find(b))
                return edge;
            sets.union(a,b);
        }
        
        return null;
    }
}
class Solution {
    
    public static class DSU {
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
        
        public void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py) return;
            
            if(rank[px] >= rank[py]){
                parent[py] = px;
                rank[px] += rank[py];
            } else {
                parent[px] = py;
                rank[py] += rank[px];
            }
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU set = new DSU(n + 1);
        
        for(int[] edge : edges){
            int src = edge[0], dest = edge[1];
            if(set.find(src) == set.find(dest)){
                return edge;
            }
            
            set.union(src, dest);
        }
        
        return null;
    }
}
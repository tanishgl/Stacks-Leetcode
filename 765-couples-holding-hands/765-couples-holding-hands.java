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
    
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        DSU set = new DSU(n);
        int swaps = 0;
        
        for(int i=0;i<n;i+=2){
            set.union(row[i], row[i+1]);
        }
        
        for(int i=0;i<n;i+=2){
            if(set.find(i) != set.find(i+1)){
                set.union(i, i+1);
                swaps++;
            }
        }
        
        return swaps;
    }
}
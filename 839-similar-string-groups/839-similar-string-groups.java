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
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU sets = new DSU(n);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isSimilar(strs[i], strs[j]))
                    sets.union(i, j);
            }
        }
        
        int groups = 0;
        for(int i=0;i<n;i++){
            if(sets.find(i) == i) groups++;
        }
        
        return groups;
    }
    
    public boolean isSimilar(String a, String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i))
                count++;
        }
        
        if(count <= 2) return true;
        return false;
    }
}
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
    
    public boolean equationsPossible(String[] equations) {
        DSU sets = new DSU(26);
        
        for(String eqn : equations){
            int left = eqn.charAt(0) - 'a';
            int right = eqn.charAt(3) - 'a';
            if(eqn.charAt(1) == '='){
                sets.union(left, right);
            }
        }
        
        for(String eqn : equations){
            int left = eqn.charAt(0) - 'a';
            int right = eqn.charAt(3) - 'a';
            if(eqn.charAt(1) == '!'){
                if(sets.find(left) == sets.find(right))
                    return false;
            }
        }
        
        return true;
    }
}
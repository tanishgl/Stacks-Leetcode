class Solution {
    
    static class DSU{
        int[] parent, rank;
        
        DSU(int n){
            parent = new int[n];
            Arrays.fill(parent, -1);
            rank = new int[n];
            Arrays.fill(rank, 1);
        }
        
        public int find(int x){
            if(parent[x] == -1)
                return x;
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
    
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        DSU set = new DSU(26);
        
        for(String eqn : equations){
            if(eqn.charAt(1) == '='){
                set.union(eqn.charAt(0)-'a', eqn.charAt(3)-'a');
            }
        }
        
        for(String eqn : equations){
            if(eqn.charAt(1) == '=')
                continue;
            if(set.find(eqn.charAt(0)-'a') == set.find(eqn.charAt(3)-'a'))
                return false;
        }
        
        return true;
    }
}
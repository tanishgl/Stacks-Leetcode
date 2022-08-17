class Solution {
    
    static class DSU {
        int[] parent, rank;
        DSU(int n){
            parent = new int[n];
            Arrays.fill(parent, -1);
            rank = new int[n];
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
                rank[b] += rank[b];
            }
        }
        
        public int compCount(){
            int count = 0;
            for(int i=0;i<parent.length;i++){
                if(parent[i] == -1) count++;
            }
            return count;
        }
    }
    
    public boolean isSimilar(String a, String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i))
                count++;
        }
        return count <= 2;
    }
    
    
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU set = new DSU(n);
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i], strs[j]))
                    set.union(i,j);
            }
        }
        
        return set.compCount();
    }
}
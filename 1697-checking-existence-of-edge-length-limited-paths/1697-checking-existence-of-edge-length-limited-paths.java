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
    
    public static class Query{
        int idx, a, b, threshold;
        Query(int idx, int a, int b, int threshold){
            this.a = a;
            this.b = b;
            this.idx = idx;
            this.threshold = threshold;
        }
    }
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        List<Query> q = new ArrayList<>();
        for(int i = 0; i< queries.length; i++){
            int[] qr = queries[i];
            q.add(new Query(i, qr[0], qr[1], qr[2]));
        }
        
        Collections.sort(q, (a, b) -> a.threshold - b.threshold);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        
        boolean[] ans = new boolean[queries.length];
        DSU sets = new DSU(n);
        int e = 0;
        
        for(Query qr : q){
            while(e < edgeList.length && edgeList[e][2] < qr.threshold){
                sets.union(edgeList[e][0], edgeList[e][1]);
                e++;
            }
            
            if(sets.find(qr.a) == sets.find(qr.b))
                ans[qr.idx] = true;
        }
        
        return ans;
    }
}
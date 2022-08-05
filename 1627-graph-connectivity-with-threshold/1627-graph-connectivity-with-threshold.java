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
    
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        DSU sets = new DSU(n+1);
        List<Boolean> ans = new ArrayList<>();
        
        for(int i=1;i<=n;i++)
            for(int j=i;j<=n;j+=i)
                if(gcd(i, j) > threshold)
                    sets.union(i, j);
           
        for(int[] q : queries){
            if(sets.find(q[0]) == sets.find(q[1]))
                ans.add(true);
            else
                ans.add(false);
        }
          
        return ans;
        
    }
    
    public int gcd(int a, int b){
        while(a%b>0){
            int c = a % b;
            a = b;
            b = c;
        }
        
        return b;
    }
}
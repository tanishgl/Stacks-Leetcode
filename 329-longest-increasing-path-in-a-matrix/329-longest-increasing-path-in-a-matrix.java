class Solution {
    
    public static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static int[] x = {0,1,0,-1};
    public static int[] y = {1,0,-1,0};
    
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] inc = new int[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<4;k++){
                    int nr = i + x[k];
                    int nc = j + y[k];
                    if(nr < 0 || nr >= n || nc < 0 || nc >=m || matrix[nr][nc] >= matrix[i][j]) continue;
                    inc[i][j]++;
                }
                if(inc[i][j] == 0) q.add(new Pair(i,j));
            }
        }
        
        Pair[] topo = new Pair[n*m];
        int idx = 0;
        
        while(q.size()>0){
            Pair p = q.remove();
            topo[idx++] = new Pair(p.x, p.y); 
            for(int k=0;k<4;k++){
                int nr = p.x + x[k];
                int nc = p.y + y[k];
                if(nr < 0 || nr >= n || nc < 0 || nc >=m || matrix[nr][nc] <= matrix[p.x][p.y]) continue;
                inc[nr][nc]--;
                if(inc[nr][nc] == 0)
                    q.add(new Pair(nr, nc));
            }
        }
        
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i], 1);
        }
        
        int res = 1;
        
        for(int i=topo.length-1;i>=0;i--){
            int mr = topo[i].x, mc = topo[i].y;
            for(int j=i+1;j<topo.length;j++){
                int yr = topo[j].x, yc = topo[j].y;
                if(matrix[mr][mc] >= matrix[yr][yc])
                    continue;
                if((Math.abs(yr-mr) == 0 && Math.abs(yc-mc) == 1) || (Math.abs(yr-mr) == 1 && Math.abs(yc-mc) == 0)){
                    ans[mr][mc] = Math.max(ans[mr][mc], ans[yr][yc] + 1);
                    // System.out.println("hi");
                }
            }
            res = Math.max(res, ans[mr][mc]);
        }
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 System.out.print(ans[i][j] + " ");
//             }
//             System.out.println();
//         }
        
        return res;
        
        
    }
}
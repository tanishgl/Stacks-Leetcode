class Solution {
    int[] x = {0, 1, 0, -1};
    int[] y = {1, 0, -1, 0};
    
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        boolean[][] vis2 = new boolean[n][m];
        
        // Pacific ocean.
        for(int i=0;i<m;i++){
            if(!vis[0][i])
                DFS(0, i, grid, vis);
            if(!vis2[n-1][i])
                DFS(n-1, i, grid, vis2);
        }
        
        for(int i=0;i<n;i++){
            if(!vis[i][0])
                DFS(i, 0, grid, vis);
            if(!vis2[i][m-1])
                DFS(i, m-1, grid, vis2);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] && vis2[i][j]){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    res.add(ans);
                }
            }
        }
        
        return res;
    }
    
    public void DFS(int sr, int sc, int[][] grid, boolean[][] vis){
        if(sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || vis[sr][sc]){
            return;
        }
        
        vis[sr][sc] = true;
    
        for(int i=0;i<4;i++){
            int nr = sr + x[i];
            int nc = sc + y[i];
            if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || vis[nr][nc] || grid[nr][nc] < grid[sr][sc])
                continue;
            
            DFS(nr, nc, grid, vis);
        }
    }
}
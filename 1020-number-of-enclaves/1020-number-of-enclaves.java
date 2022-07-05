class Solution {
    
    public static int[] x = {0, 1, 0, -1};
    public static int[] y = {1, 0, -1, 0};
    
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // 1. Apply DFS1 for all the boundary cells.
        for(int i=0;i<n;i++){
            DFS(i, 0, grid);
            DFS(i, m - 1, grid);
        }
        
        for(int i=0;i<m;i++){
            DFS(0, i, grid);
            DFS(n - 1, i, grid);
        }
        
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        
        return count;

    }
    
    public void DFS(int sr, int sc, int[][] grid){
        if(sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length || grid[sr][sc] == 0 || grid[sr][sc] == -1){
            return;
        }
        
        grid[sr][sc] = -1;
        
        for(int i=0;i<4;i++){
            DFS(sr + x[i], sc + y[i], grid);
        }
        
    }
}
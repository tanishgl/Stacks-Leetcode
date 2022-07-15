class Solution {
    
    public static int[] x = {0,0,1,-1};
    public static int[] y = {1,-1,0,0};
    public static int size = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, maxSize = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    DFS(i, j, grid);
                    maxSize = Math.max(size, maxSize);
                    size = 0;
                }
            }
        }
        
        return maxSize;
    }
    
    public void DFS(int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0)
            return;
        
        //visit this cell.
        size++;
        grid[row][col] = 0;
        
        for(int i=0;i<4;i++){
            int nr = row + x[i];
            int nc = col + y[i];
            DFS(nr, nc, grid);
        }
    }
}
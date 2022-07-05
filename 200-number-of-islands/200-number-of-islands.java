class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    DFS(i, j, grid);
                }
            }
        }
        
        return count;
    }
    
    public void DFS(int sr, int sc, char[][] grid){
        if(sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length || grid[sr][sc] == '0' || grid[sr][sc] == 'N')
            return;
        
        grid[sr][sc] = 'N';
        
        DFS(sr - 1, sc, grid);
        DFS(sr, sc + 1, grid);
        DFS(sr + 1, sc, grid);
        DFS(sr, sc - 1, grid);
    }
}
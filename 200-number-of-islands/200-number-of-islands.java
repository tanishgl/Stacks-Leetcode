class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    DFS(i, j, grid);
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    public void DFS(int sr, int sc, char[][] grid){
        if(sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || grid[sr][sc] == 'N' || grid[sr][sc] == '0') return;
        
        grid[sr][sc] = 'N';
        DFS(sr - 1, sc, grid);
        DFS(sr, sc + 1, grid);
        DFS(sr + 1, sc, grid);
        DFS(sr, sc - 1, grid);
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int boxes = 0;
        int edges = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    boxes++;
                    // Check downwards edge
                    if(i+1 < n && grid[i+1][j] == 1)
                        edges++;
                    //Check rightwards edge
                    if(j+1 < m && grid[i][j+1] == 1)
                        edges++;
                }
            }
        }
        
        return 4 * boxes - 2 * edges;
    }
}
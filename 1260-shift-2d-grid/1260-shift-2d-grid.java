class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        while(k-->0){
            int[] lastRow = new int[m];
            for(int i=0;i<m;i++){
                lastRow[i] = grid[i][n-1];
            }
            
            for(int i=0;i<m;i++){
                for(int j=n-2;j>=0;j--){
                    grid[i][j+1] = grid[i][j];
                }
            }
            
            grid[0][0] = lastRow[lastRow.length-1];
            
            for(int i=1;i<m;i++){
                grid[i][0] = lastRow[i-1];
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            res.add(new ArrayList<Integer>());
            for(int j=0;j<n;j++){
                res.get(i).add(grid[i][j]);
            }
        }
        
        return res;
    }
}
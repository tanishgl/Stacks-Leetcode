class Solution {
    
    public static class Pair{
        int x;
        int y;
        int t;
        Pair(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    
    public static int[] x = {0, 1, 0, -1};
    public static int[] y = {1, 0, -1, 0};
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        
        int time = 0;
        
        while(q.size()>0){
            Pair orange = q.remove();
            // Already rotten
            if(grid[orange.x][orange.y] == 3) continue;
            // Now it becomes rotten.
            grid[orange.x][orange.y] = 3;
            // Update time
            time = Math.max(time, orange.t);
            
            for(int i=0;i<4;i++){
                int nr = orange.x + x[i];
                int nc = orange.y + y[i];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(grid[nr][nc] == 0 || grid[nr][nc] == 3) continue;
                q.add(new Pair(nr, nc, orange.t + 1));
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        
        return time;
    }
}
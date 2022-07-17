class Solution {
    
    public static class Pair{
        int row, col, rev;
        Pair(int row, int col, int rev){
            this.row = row;
            this.col = col;
            this.rev = rev;
        }
        
    }
    
    public static int[] x = {0, 0, 1, -1};
    public static int[] y = {1, -1, 0, 0};
    
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Deque<Pair> q = new ArrayDeque<>();
        q.addFirst(new Pair(0,0,0));
        
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }
        
        while(q.size()>0){
            Pair curr = q.remove();
            if(vis[curr.row][curr.col] <= curr.rev) continue;
            vis[curr.row][curr.col] = curr.rev;
            
            for(int i=1;i<=4;i++){
                int nr = x[i-1] + curr.row;
                int nc = y[i-1] + curr.col;
                if(nr < 0 || nc < 0 || nr >=n || nc >= m) continue;
                if(grid[curr.row][curr.col] == i){
                    q.addFirst(new Pair(nr, nc, curr.rev));
                } else {
                    q.addLast(new Pair(nr, nc, curr.rev + 1));
                }
            }
        }
        
        return vis[n-1][m-1];
    }
}
class Solution {
    
    public static class Pair{
        int x, y, cost;
        Pair(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        
    }
    
    public static int[] x = {0,0,1,-1};
    public static int[] y = {1,-1,0,0};
    
    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Pair(0,0,0));
        
        boolean[][] vis = new boolean[n][m];
        while(pq.size()>0){
            Pair curr = pq.remove();
            if(curr.x == n - 1 && curr.y == m - 1)
                return curr.cost;
            if(vis[curr.x][curr.y]) continue;
            vis[curr.x][curr.y] = true;
            
            for(int i=0;i<4;i++){
                int nr = curr.x + x[i];
                int nc = curr.y + y[i];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                pq.add(new Pair(nr, nc, curr.cost + grid[nr][nc]));
            }
        }
        
        return -1;
    }
}
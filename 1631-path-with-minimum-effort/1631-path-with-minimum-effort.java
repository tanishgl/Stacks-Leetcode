class Solution {
    
    public static class Pair{
        int row, col, diff;
        Pair(int row, int col, int diff){
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
        
    }
    
    public static int[] x = {0,0,1,-1};
    public static int[] y = {1,-1,0,0};
    
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.diff - b.diff);
        q.add(new Pair(0,0,0));
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }
        
        while(q.size()>0){
            Pair curr = q.remove();
            if(vis[curr.row][curr.col] <= curr.diff) continue;
            vis[curr.row][curr.col] = curr.diff;
            
            for(int i=0;i<4;i++){
                int nr = curr.row + x[i];
                int nc = curr.col + y[i];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                q.add(new Pair(nr, nc, Math.max(curr.diff, Math.abs(heights[nr][nc] - heights[curr.row][curr.col]))));
            }
        }
        
        return vis[n-1][m-1];
    }
}
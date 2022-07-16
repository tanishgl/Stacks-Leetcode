class Solution {
    
    public static class Pair{
        int src;
        int dist;
        
        Pair(int src, int dist){
            this.src = src;
            this.dist = dist;
        }
    }
    
    public int BFS(ArrayList<Integer>[] adj){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 0));
        
        int[] vis = new int[adj.length + 1];
        Arrays.fill(vis, -1);
        
        while(q.size()>0){
            Pair curr = q.remove();
            if(vis[curr.src] != -1) continue;
            vis[curr.src] = curr.dist;
            
            for(int nbr : adj[curr.src]){
                q.add(new Pair(nbr, curr.dist + 1));
            }
        }
                      
        return vis[adj.length - 1];
    }
    
    public int snakesAndLadders(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        
        // Convert 2-D into 1-D.
        ArrayList<Integer> board = new ArrayList<>();
        // For 1-based indexing 
        board.add(0);
        
        // Zig-Zag Traversing
        int level = 0, cell = 1;
        for(int i=n-1;i>=0;i--){
            if(level % 2 == 0){
                for(int j=0;j<n;j++){
                    if(grid[i][j] == -1)
                        board.add(cell);
                    else board.add(grid[i][j]);
                    cell++;
                }
            } else {
                for(int j=n-1;j>=0;j--){
                    if(grid[i][j] == -1)
                        board.add(cell);
                    else board.add(grid[i][j]);
                    cell++;
                }
            }
            
            level++;
        }
        
        ArrayList<Integer>[] adj = new ArrayList[size + 1];
        
        for(cell = 1; cell <= size; cell++){
            adj[cell] = new ArrayList<>();
            for(int d = 1; d <= 6 && cell + d <= size; d++){
                if(board.get(cell + d) == cell) continue;
                adj[cell].add(board.get(cell + d));
            }
        }
        
        return BFS(adj);
    }
}
class Solution {
    public int totalNQueens(int n) {
        boolean[][] vis = new boolean[n][n];
        return NQueens(n,0,vis);
    }
    
    public static int NQueens(int n, int row, boolean[][] vis){
        //base case
        if(row==n){
            return 1;
        }
        
        int fans = 0;
        
        for(int i=0;i<n;i++){
            if(isPossible(row,i,vis)){
                vis[row][i] = true;
                
                int futureans = NQueens(n, row + 1, vis);
                fans += futureans;
                
                vis[row][i] = false;
            }
        }
        
        return fans;
    }
    
    public static boolean isPossible(int r, int c, boolean[][] vis){
        int n = vis.length;
        for(int i=r;i>=0;i--){
            if(vis[i][c]==true) return false;
        }
        
        for(int i=r,j=c;i>=0 && j>=0; i--,j--){
            if(vis[i][j]==true) return false;
        }
        
        for(int i=r,j=c;i>=0 && j<n; i--,j++){
            if(vis[i][j]==true) return false;
        }
        
        return true;
    }
}
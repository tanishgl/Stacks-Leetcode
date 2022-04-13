class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        
        int frow = 0;
        int fcol = 0;
        int lrow = n-1;
        int lcol = n-1;
        int x = 1;
        
        while(fcol<=lcol && frow<=lrow){
            for(int i=fcol;i<=lcol;i++){
                mat[frow][i] = x;
                x++;
            }
            
            frow++;
            
            for(int i=frow;i<=lrow;i++){
                mat[i][lcol] = x;
                x++;
            }
            
            lcol--; 
            
            for(int i=lcol;i>=fcol;i--){
                mat[lrow][i] = x;
                x++;
            }
            
            lrow--;
            
            for(int i=lrow;i>=frow;i--){
                mat[i][fcol] = x;
                x++;
            }
            
            fcol++;
            
        }
        
        return mat;
    }
}
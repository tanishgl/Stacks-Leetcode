class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] vis = new boolean[n][n];
        List<List<String>> ans = NQueens(n,0,vis);
        return ans;
    }
    
    public static List<List<String>> NQueens(int n, int row, boolean[][] vis){
        //base case
        if(row==n){
            List<List<String>> fans = new ArrayList<>();
            List<String> base = new ArrayList<>();
            base.add("");
            fans.add(base);
            return fans;
        }
        
        List<List<String>> fans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(isPossible(row,i,vis)){
                vis[row][i] = true;
                
                List<List<String>> futureans = NQueens(n, row + 1, vis);
                
                if(futureans.size()>0){
                    
                    //System.out.println(i);
                    String config = "";
                    for(int j=0;j<i;j++){
                        config += ".";
                    }
                    config += "Q";
                    for(int j=i+1;j<n;j++){
                        config += ".";
                    }
                    
                    //System.out.println(config);
                    for(int j=0;j<futureans.size();j++){
                        List<String> res = new ArrayList<>();
                        res.add(config);
                        for(int k=0;k<futureans.get(j).size();k++){
                            res.add(futureans.get(j).get(k));
                        }
                        res.remove("");
                        fans.add(res);
                        //res.add(futureans.get(j));
                    }
//                     res.remove("");
                    
//                     fans.add(res);
                    
                }
                
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
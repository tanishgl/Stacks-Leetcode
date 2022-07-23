class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}

class Solution {
    
    public int[] x = {0,0,1,-1};
    public int[] y = {1,-1,0,0};
    
    public int longestIncreasingPath(int[][] matrix) {
        
        // Step 1 :- Prepare the incoming matrix.
        int n = matrix.length, m = matrix[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        int[][] inc = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<4;k++){
                    int nr = i + x[k];
                    int nc = j + y[k];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= m || matrix[nr][nc] >= matrix[i][j]) continue;
                    inc[i][j]++;
                }
                if(inc[i][j] == 0)
                    q.add(new Pair(i,j));
            }
        }
    
        // Step 3 :- Maintain a visited matrix and initialize array to store topo sort.
        Pair[] sort = new Pair[n*m];
        int idx = 0;
        
        // Step 4 :- Apply Kahn's algorithm.
        while(q.size()>0){
            Pair curr = q.remove();
            sort[idx++] = new Pair(curr.x, curr.y);
            
            for(int k=0;k<4;k++){
                int nr = curr.x + x[k];
                int nc = curr.y + y[k];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m || matrix[nr][nc] <= matrix[curr.x][curr.y]) continue;
                inc[nr][nc]--;
                if(inc[nr][nc] == 0)
                    q.add(new Pair(nr, nc));
            }
        }
        
        // Step 5 :- Figuring out the answer finally.
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i], 1);
        }
        
        int res = 1;
        
        for(int i=sort.length-1;i>=0;i--){
            int mr = sort[i].x, mc = sort[i].y;
            for(int j=i+1;j<sort.length;j++){
                int yr = sort[j].x, yc = sort[j].y;
                if(matrix[mr][mc] >= matrix[yr][yc])
                    continue;
                if((Math.abs(yr-mr) == 0 && Math.abs(yc-mc) == 1) || (Math.abs(yr-mr) == 1 && Math.abs(yc-mc) == 0)){
                    ans[mr][mc] = Math.max(ans[mr][mc], ans[yr][yc] + 1);
                    // System.out.println("hi");
                }
            }
            res = Math.max(res, ans[mr][mc]);
        }
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 System.out.print(ans[i][j] + " ");
//             }
//             System.out.println();
//         }
        
        return res;
    }
}
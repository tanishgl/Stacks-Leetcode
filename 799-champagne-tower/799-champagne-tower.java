class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] pascal = new double[101][101];
        pascal[0][0] = poured;
        
        for(int i=0;i<=query_row;i++){
            for(int j=0;j<=query_glass;j++){
                if(pascal[i][j] > 1.0){
                    pascal[i+1][j] += (pascal[i][j] - 1.0) / 2.0;
                    pascal[i+1][j+1] += (pascal[i][j] - 1.0) / 2.0;
                    pascal[i][j] = 1;
                }
            }
        }
        
        return pascal[query_row][query_glass];
    }
}
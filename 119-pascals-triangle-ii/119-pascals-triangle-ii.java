class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascal = generate(rowIndex + 1);
        return pascal.get(pascal.size() - 1);
    }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(1);
        
        int[][] dp = new int[numRows + 1][numRows + 1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1); // nC1
            
            for(int j=1;j<i;j++){
                // nCk = n-1Ck + n-1Ck-1
                int nCk = res.get(i-1).get(j) + res.get(i-1).get(j-1);
                row.add(nCk);
            }
            
            row.add(1); // nCn
            res.add(row);
        }
        
        return res;
    }
}
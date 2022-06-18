class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        
        for(int i=1;i<=rowIndex;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            
            for(int j=1;j<i;j++){
                row.add(prev.get(j) + prev.get(j-1));
            }
            
            row.add(1);
            
            prev = row;
        }
        
        return prev;
    }
}
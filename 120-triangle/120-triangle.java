class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                int below = triangle.get(i+1).get(j);
                int adjacent = triangle.get(i+1).get(j+1);
                int ans = Math.min(below, adjacent) + triangle.get(i).get(j);
                triangle.get(i).set(j, ans);
            }
        }
        
        return triangle.get(0).get(0);
    }
}
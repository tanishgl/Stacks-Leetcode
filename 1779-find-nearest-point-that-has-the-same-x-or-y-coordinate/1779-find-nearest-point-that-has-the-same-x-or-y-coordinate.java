class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        
        for(int i=0;i<points.length;i++){
            int[] coord = points[i];
            if(coord[0] == x || coord[1] == y){
                int manhattan = Math.abs(x - coord[0]) + Math.abs(y - coord[1]);
                if(manhattan < ans){
                    ans = manhattan;
                    idx = i;
                }
            }
        }
        
        return (ans == Integer.MAX_VALUE) ? -1 : idx;
    }
}
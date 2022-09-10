class Solution {
    
    static int[] x = {0, 1, 0, -1};
    static int[] y = {1, 0, -1, 0};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        
        int old = image[sr][sc];
        image[sr][sc] = color;
        
        for(int i=0;i<4;i++){
            DFS(image, sr, sc, sr + x[i], sc + y[i], color, old);
        }
        return image;
    }   
    
    public void DFS(int[][] image, int pr, int pc, int cr, int cc, int color, int old){
        // System.out.println("Row -> " + cr + " Col -> " + cc);
        if(cr < 0 || cc < 0 || cr >= image.length || cc >= image[0].length)
            return;
        if(image[cr][cc] != old)
            return;
        image[cr][cc] = color;
        // System.out.println("Color changed");
        
        for(int i=0;i<4;i++){
            DFS(image, cr, cc, cr + x[i], cc + y[i], color, old);
        }
    }
}
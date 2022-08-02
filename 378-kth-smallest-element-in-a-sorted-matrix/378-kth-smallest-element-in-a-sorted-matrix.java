class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i)*(j+1) + j < k){
                    // I can be kth smallest.
                    pq.add(matrix[i][j]);
                }
            }
        }
        
        for(int i=0;i<k-1 && pq.size()>0;i++)
            pq.remove();
        
        return pq.remove();
    }
}
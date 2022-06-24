class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(int i=0;i<score.length;i++){
            minHeap.add(new int[]{i, score[i]});
        }
        
        HashMap<Integer, String> map = new HashMap<>();
        int rank = score.length;
        while(minHeap.size()>0){
            int[] x = minHeap.remove();
            if(rank > 3){
                map.put(x[0], rank+"");
            } else {
                if(rank == 3)
                    map.put(x[0], "Bronze Medal");
                else if (rank == 2)
                    map.put(x[0], "Silver Medal");
                else if (rank == 1)
                    map.put(x[0], "Gold Medal");
            }
            rank--;
        }
        
        String[] op = new String[score.length];
        for(int i=0;i<op.length;i++){
            op[i] = map.get(i);
        }
        
        return op;
    }
}
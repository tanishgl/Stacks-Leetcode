class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        ArrayList<Integer> al = new ArrayList<>();
        for(int val : stones)
            al.add(val);
        
        maxHeap.addAll(al);
        
        while(maxHeap.size()>1){
            int y = maxHeap.remove();
            int x = maxHeap.remove();
            if(x != y)
                maxHeap.add(y - x);
        }
        
        if(maxHeap.size() == 0) return 0;
        return maxHeap.remove();
    }
}
class Solution {
    public int minPartitions(String n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n.length();i++){
            heap.add(n.charAt(i)-'0');
        }
        
        return heap.remove();
    }
}
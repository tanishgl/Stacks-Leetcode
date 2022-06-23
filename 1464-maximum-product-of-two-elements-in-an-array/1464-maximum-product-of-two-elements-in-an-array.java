class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> al = new ArrayList<>();
        for(int val : nums)
            al.add(val);
        
        maxHeap.addAll(al);
        
        return (maxHeap.remove()-1) * (maxHeap.remove()-1);
    }
}
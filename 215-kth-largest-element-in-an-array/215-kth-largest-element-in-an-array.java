class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0;i<nums.length;i++){
            if(i < k){
                minHeap.add(nums[i]);
            } else {
                int lp = minHeap.peek();
                if(lp < nums[i]){
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
        }
        
        return minHeap.remove();
    }
}
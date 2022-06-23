class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for(int key : map.keySet()){
            minHeap.add(new int[]{key, map.get(key)});
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        
        int[] ans = new int[k];
        while(k > 0){
            ans[--k] = minHeap.remove()[0];
        }
        
        return ans;
    }
}
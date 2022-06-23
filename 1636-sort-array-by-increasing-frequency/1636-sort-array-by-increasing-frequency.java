class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        
        for(int key : map.keySet()){
            minHeap.add(new int[]{key, map.get(key)});
        }
        
        int[] op = new int[nums.length];
        int idx = 0;
        
        while(minHeap.size()>0){
            int[] pair = minHeap.remove();
            for(int i=1;i<=pair[1];i++){
                op[idx++] = pair[0];
            }
        }
        
        return op;
        
    }
}
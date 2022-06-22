class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        List<Integer> al = new ArrayList<>();
        for(int val : nums)
            if(!al.contains(val)) al.add(val);
        
        pq.addAll(al);
        
        if(pq.size() < 3) return pq.remove();
        
        int ans = -1, i = 0;
        while(pq.size() > 0 && i < 3){
            ans = pq.remove();
            i++;
        }
        
        return ans;
    }
}
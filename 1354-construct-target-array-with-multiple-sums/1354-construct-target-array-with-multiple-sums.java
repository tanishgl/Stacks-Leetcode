class Solution {
    public boolean isPossible(int[] target) {
        if(target.length == 1) return target[0] == 1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for(int val : target){
            sum += val;
            pq.add(val);
        }
            
        while(pq.peek() != 1){
            int curr = pq.remove();
            if(sum - curr == 1) return true;
            
            int x = curr % (sum - curr);
            sum = sum - curr + x;
            
            if(x == 0 || x == curr) return false;
            else pq.add(x);
        }
        
        return true;
        
    }
}
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> carton = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int count = 0, day = 1;
        
        // Iterate as long as carton is not empty or the tree still gives apples.
        
        while(day <= days.length || carton.size() > 0){
            // 1. First add today's packet into the carton {apples, expiry}.
            if(day <= days.length){
                carton.add(new int[]{apples[day-1], days[day-1] + day});
            }
            
            // 2. Remove rotten and empty packets.
            while(carton.size() > 0 && (carton.peek()[0] <= 0 || carton.peek()[1] <= day)){
                carton.remove();
            }
            
            // 3. Time to eat today's apple, if available.
            if(carton.size() > 0){
                count++;
                int[] packet = carton.remove();
                carton.add(new int[]{packet[0] - 1, packet[1]});
            }
            
            day++;
        }
        
        return count;
    }
}
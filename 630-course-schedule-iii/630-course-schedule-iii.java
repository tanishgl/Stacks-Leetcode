class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;
        for(int i=0;i<courses.length;i++){
            time += courses[i][0];
            pq.add(courses[i][0]);
            if(time > courses[i][1]){
                time -= pq.remove();
            }
        }
        
        return pq.size();
    }
}
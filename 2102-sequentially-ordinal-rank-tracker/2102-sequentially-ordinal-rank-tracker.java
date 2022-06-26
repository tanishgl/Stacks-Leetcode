class SORTracker {
    
    static class Pair{
        String name;
        int score;
        Pair(String name, int score){
            this.name = name;
            this.score = score;
        }
    }
    
    PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.score != b.score ? a.score - b.score : b.name.compareTo(a.name));
    
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> a.score != b.score ? b.score - a.score : a.name.compareTo(b.name));
    
    int query = 1;

    public SORTracker() {
        
    }
    
    public void add(String name, int score) {
        minHeap.add(new Pair(name, score));
        while(minHeap.size() > query){
            maxHeap.add(minHeap.remove());
        }
    }
    
    public String get() {
        String ans = minHeap.peek().name;
        
        query++;
        if(maxHeap.size() > 0){
            minHeap.add(maxHeap.remove());
        }
        
        return ans;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
class MedianFinder {
    
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    double median = 0.0;

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(left.size() == 0 || num <= median)
            left.add(num);
        else 
            right.add(num);
        
        // Balancing
        if(left.size() - right.size() > 1){
            right.add(left.remove());
        } else if (right.size() - left.size() > 1){
            left.add(right.remove());
        }
        
        median = (left.size() == right.size()) ? (left.peek() + right.peek()) / 2.0 : (left.size() > right.size()) ? left.peek() : right.peek();
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
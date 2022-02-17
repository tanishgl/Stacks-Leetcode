class FrontMiddleBackQueue {
    
    Deque<Integer> left = new ArrayDeque<>();
    Deque<Integer> right = new ArrayDeque<>();

    public void balance() {
        
        if((left.size() + right.size()) % 2 == 0){
            while(left.size()>right.size()){
                right.addFirst(left.removeLast());
            }
            
            while(right.size()>left.size()){
                left.addLast(right.removeFirst());
            }
        } else {
             while(left.size()>right.size() + 1){
                right.addFirst(left.removeLast());
            }
            
            while(right.size() + 1>left.size()){
                left.addLast(right.removeFirst());
            }
        }
    }
    
    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }
    
    public void pushMiddle(int val) {
        if(left.size()>right.size()){
            right.addFirst(left.removeLast());
            left.addLast(val);
        } else {
            left.addLast(val);
        }
        balance();
    }
    
    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }
    
    public int popFront() {
        if(left.size() + right.size()==0) return -1;
        
        int data = left.getFirst();
        left.removeFirst();
        balance();
        
        return data;
    }
    
    public int popMiddle() {
        if(left.size() + right.size()==0) return -1;
        
        int data = left.getLast();
        left.removeLast();
        balance();
        
        return data;
    }
    
    public int popBack() {
        if(left.size() + right.size()==0) return -1;
        int data = 0;
        if(right.size()==0){
             data = left.getLast();
            left.removeLast();
        } else {
             data = right.getLast();
            right.removeLast();
        }
        
        balance();
        return data;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
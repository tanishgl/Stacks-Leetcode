class MyStack {
    
    Queue<Integer> mainq = new ArrayDeque<>();
    Queue<Integer> secq = new ArrayDeque<>();
    int size = 0;

    public MyStack() {
        
    }
    
    public void push(int x) {
        while(mainq.size()>0){
            secq.add(mainq.remove());
        }
        mainq.add(x);
        while(secq.size()>0){
            mainq.add(secq.remove());
        }
        size++;
    }
    
    public int pop() {
        size--;
        return mainq.remove();
    }
    
    public int top() {
        return mainq.peek();
    }
    
    public boolean empty() {
        return size==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
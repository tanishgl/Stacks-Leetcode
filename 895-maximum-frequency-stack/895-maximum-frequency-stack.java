class FreqStack {
    
    HashMap<Integer, Integer> nodes = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> freq = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {
        
    }
    
    public void push(int val) {
        //Update the frequency of the nodes.
        nodes.put(val, nodes.getOrDefault(val, 0) + 1);
        int currFreq = nodes.get(val);
        
        //Update the nodes relative to their frequency.
        if(freq.containsKey(currFreq)==false){
            freq.put(currFreq, new ArrayList<>());
        }
        
        freq.get(currFreq).add(val);
        maxFreq = Math.max(maxFreq, currFreq);
    }
    
    public int pop() {
        //Now, we have to pop the highest frequency element.
        ArrayList<Integer> al = freq.get(maxFreq);
        int data = al.get(al.size() - 1);
        al.remove(al.size() - 1);
        
        if(al.size()==0){
            freq.remove(maxFreq);
            maxFreq--;
        } else {
            freq.put(maxFreq, al);
        }
        
        //Update the nodes hashmap also.
        nodes.put(data, nodes.get(data)-1);
        
        return data;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
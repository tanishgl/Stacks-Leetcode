class MapSum {
    
    public static class Node {
        private Node[] children = new Node[26];
        private int value = 0;
        public int prefix = 0;
        
        public boolean contains(char ch){
            return children[ch-'a'] != null;
        }
        
        public Node get(char ch){
            return children[ch-'a'];
        }
        
        public void set(char ch){
            children[ch-'a'] = new Node();
        }
        
        public int getValue(){
            return this.value;
        }
        
        public void setValue(int value){
            this.value = value;
        }
    }
    
    Node root;

    public MapSum() {
        root = new Node();
    }
    
    public int search(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!curr.contains(ch))
                return 0;
            curr = curr.get(ch);
        }
        return curr.getValue();
    }
    
    public void insert(String key, int val) {
        int oldVal = search(key);
        Node curr = root;
        for(int i=0;i<key.length();i++){
            curr.prefix += (val - oldVal);
            char ch = key.charAt(i);
            if(!curr.contains(ch))
                curr.set(ch);
            curr = curr.get(ch);
        }
        
        curr.prefix += (val - oldVal);
        curr.setValue(val);
    }
    
    public int sum(String prefix) {
        Node curr = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!curr.contains(ch))
                return 0;
            curr = curr.get(ch);
        }
        
        return curr.prefix;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
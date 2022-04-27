class StreamChecker {
    
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
       
        public boolean contains(char ch){
            return this.children[ch-'a'] != null;
        }
       
        public Node get(char ch){
            return this.children[ch-'a'];
        }
       
        public void set(char ch){
            this.children[ch-'a'] = new Node();
        }
       
        public boolean getEnd(){
            return this.isEnd;
        }
       
        public void setEnd(){
            this.isEnd = true;
        }
    }  
    
    public void insert(String word) {
        Node curr = root;
        for(int i=word.length()-1;i>=0;i--){
            char ch = word.charAt(i);
            if(!curr.contains(ch)){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
   
    Node root;

    public StreamChecker(String[] words) {
        root = new Node();
        for(String str : words){
            insert(str);
        }
    }
    
    StringBuilder stream = new StringBuilder();
    
    public boolean query(char letter) {
        stream.append(letter);
        Node curr = root;
        for(int i=stream.length()-1;i>=0;i--){
            if(curr.getEnd()) return true;
            
            char ch = stream.charAt(i);
            if(!curr.contains(ch)) return false;
            
            curr = curr.get(ch);
        }
        
        return curr.getEnd();
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
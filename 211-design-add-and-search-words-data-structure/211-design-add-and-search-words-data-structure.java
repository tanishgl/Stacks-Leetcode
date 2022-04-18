class WordDictionary {
    
    public static class Node {
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public boolean contains(char ch){
            return children[ch-'a'] != null;
        }
        
        public Node get(char ch){
            return children[ch-'a'];
        }
        
        public void set(char ch){
            children[ch-'a'] = new Node();
        }
        
        public boolean getEnd(){
            return this.isEnd;
        }
        
        public void setEnd(boolean isEnd){
            this.isEnd = isEnd;
        }
    }
    
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!curr.contains(ch)){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        
        curr.setEnd(true);
    }
    
    public boolean search(String word, int idx, Node curr){
        if(idx == word.length())
            return curr.getEnd();
        
        char ch = word.charAt(idx);
        
        if(ch != '.'){
            if(!curr.contains(ch))
                return false;
            return search(word, idx + 1, curr.get(ch));
        } 
        
        for(char chx = 'a'; chx <= 'z'; chx++){
            if(!curr.contains(chx)) continue;
            
            if(search(word, idx + 1, curr.get(chx))){
                return true;
            }
        }
        
        return false;
        
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class Solution {
    
    static class Node{
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
    
    public void insert(String word){
        Node curr = root;
        for(int i=word.length()-1;i>=0;i--){
            char ch = word.charAt(i);
            
            if(!curr.contains(ch))
                curr.set(ch);
            
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    public boolean isSuffix(String word){
        Node curr = root;
        
        for(int i=word.length()-1;i>=0;i--){
            char ch = word.charAt(i);
            if(!curr.contains(ch))
                return false;
            curr = curr.get(ch);
        }
        
        return true;
    }
    
    Node root;
    
    public int minimumLengthEncoding(String[] words) {
        root = new Node();
        
        int ans = 0, pound = 0;
        
        Arrays.sort(words, (a, b) -> {
            if(a.length() > b.length()) {
                return -1;
            } else if(a.length() < b.length()) {
                return 1;
            } else {
                return 0;
            }
        });

        for(int i=0;i<words.length;i++){
            if(!isSuffix(words[i])){
                insert(words[i]);
                ans += words[i].length();
                pound++;
            }
        }
        
        return ans + pound;
    }
    
    public void dfs(Node node){
        // Check if node is leaf node.
        
        for(char ch='a';ch<='z';ch++){
            
        }
    }
}
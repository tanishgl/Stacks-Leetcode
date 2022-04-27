class MagicDictionary {
   
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
   
    Node root;

    public MagicDictionary() {
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
        curr.setEnd();
    }
   
    public void buildDict(String[] dictionary) {
        for(String s : dictionary){
            addWord(s);
        }
    }
   
    public boolean helper(Node curr, String word, int idx, boolean change){
        if(idx==word.length())
            return curr.getEnd() && change;
       
        char ch = word.charAt(idx);
        if(curr.contains(ch)){
            boolean ans = helper(curr.get(ch), word, idx + 1, change);
            if(ans) return true;
        }
       
        if(change) return false;
       
        for(char c='a';c<='z';c++){
            if(ch==c) continue;
            if(curr.contains(c)){
                boolean ans = helper(curr.get(c), word, idx + 1, true);
                if(ans) return true;
            }
        }
       
        return false;
    }
   
    public boolean search(String searchWord) {
        return helper(root, searchWord, 0, false);
    }
}
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
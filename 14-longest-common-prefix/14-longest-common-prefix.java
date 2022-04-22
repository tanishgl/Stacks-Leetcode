class Solution {
    
    public static class Node {
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        private int prefix = 0;
        
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
        
        public void setEnd(){
            this.isEnd = true;
        }
        
        public int getPrefix(){
            return this.prefix;
        }
        
        public void increasePrefix(){
            this.prefix++;
        }
        
        public void decreasePrefix(){
            this.prefix--;
        }
        
    }
    
    public void insert(String str){
        Node curr = root;
        for(int i=0;i<str.length();i++){
            curr.increasePrefix();
            char ch = str.charAt(i);
            if(!curr.contains(ch)){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.increasePrefix();
        curr.setEnd();
    }
    
    Node root;
    
    public String longestCommonPrefix(String[] strs) {
        root = new Node();
        
        for(int i=0;i<strs.length;i++)
            insert(strs[i]);
        
        dfs(root, "");
        return res;
    }
    
    String res = "";
    
    public void dfs(Node curr, String ans){
        int count = 0;
        
        if(ans.length() > res.length()){
            res = ans;
        }
        
        if(curr.getEnd())
            return;
        
        char child = 'a';
        for(char ch = 'a'; ch<='z'; ch++){
            if(curr.contains(ch)){
                count++;
                child = ch;
            }
        }
        
        if(count == 1) dfs(curr.get(child), ans + child);
    }
}
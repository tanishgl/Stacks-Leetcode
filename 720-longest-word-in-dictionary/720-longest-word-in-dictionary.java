class Solution {
    
    public static class Node{
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
        
        public void setEnd(){
            this.isEnd = true;
        }
    }
    
    Node root;
    
    public String longestWord(String[] words) {
        root = new Node();
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        
        return dfs(root);
    }
    
    public void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!curr.contains(ch))
                curr.set(ch);
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public String dfs(Node root){
        String ans = "";
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            String x = "";
            if(root.contains(ch) && root.get(ch).getEnd()){
                x = ch + dfs(root.get(ch));
                if(x.length() > ans.length())
                    ans = x;
            }
        }
        
        return ans;
    }
}
class Solution {
    
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
        
        public void setEnd(){
            this.isEnd = true;
        }
        
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
    
    public List<String> search(String word){
        List<String> prefixes = new ArrayList<>();
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!curr.contains(ch))
                return prefixes;
            curr = curr.get(ch);
        }
        
        dfs(curr, word, prefixes);
        return prefixes;
    }
    
    public void dfs(Node root, String sof, List<String> res){
        if(root.getEnd()==true){
            if(res.size()<3) res.add(sof);
        }
        
        for(char ch='a';ch<='z';ch++){
            if(root.contains(ch)){
                dfs(root.get(ch), sof + ch, res);
                if(res.size()>3) return;
            }
        }
    }
    
    Node root;
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Node();
        for(String s : products)
            insert(s);
        
        List<List<String>> fans = new ArrayList<>();
        
        for(int i=0;i<searchWord.length();i++){
            String tbs = searchWord.substring(0, i+1);
            fans.add(search(tbs));
        }
        
        return fans;
    }
}
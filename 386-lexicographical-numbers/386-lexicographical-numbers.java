class Solution {
    public static class Node{
        private Node[] children = new Node[10];
        private boolean isEnd = false;
        
        public Node get(char ch){
            return children[ch-'0'];
        }
        
        public boolean contains(char ch){
            return children[ch-'0'] != null;
        }
        
        public void set(char ch){
            children[ch-'0'] = new Node();
        }
        
        public boolean getEnd(){
            return this.isEnd;
        }
        
        public void setEnd(){
            this.isEnd = true;
        }
    }
    
    public void insert(String str){
        Node curr = root;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!curr.contains(ch))
                curr.set(ch);
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    Node root;
    
    public List<Integer> lexicalOrder(int n) {
        root = new Node();
        for(int i=1;i<=n;i++){
            insert(i+"");
        }
        
        List<Integer> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }
    
    public void dfs(Node root, String sof, List<Integer> res){
        if(root.getEnd()){
            res.add(Integer.parseInt(sof));
        }
        
        for(char ch='0'; ch<='9'; ch++){
            if(root.contains(ch)){
                dfs(root.get(ch), sof + ch, res);
            }
        }
    }
}
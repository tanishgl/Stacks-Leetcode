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
    
    Node root; 
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Node();
        
        for(int i=0;i<dictionary.size();i++)
            insert(dictionary.get(i));
        
        String ans = "";
        
        for(int i=0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
            int idx = sentence.indexOf(' ', i);
            if(idx == -1) idx = sentence.length();
            String word = sentence.substring(i, idx);
            // System.out.println(i + " " + idx + " " + word);
            boolean exist = true;
            
            if(root.contains(ch)){
                //replace by a potential prefix.
                String prefix = shortest(root, word, 0);
                if(prefix.length()==0){
                    exist = false;
                } else {
                    ans += prefix;
                }
                
            } 
            
            if(!root.contains(ch) || !exist) {
                ans += word;
            }
            
            i = idx;
            ans += (i < sentence.length()) ? " " : "";
        }
        
        return ans;
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
    
    public String shortest(Node root, String word, int idx){
        if(idx == word.length())
            return "";
        
        char ch = word.charAt(idx);
        
        if(!root.contains(ch))
            return "";
        
        if(root.get(ch).getEnd())
            return ch+"";
        
        String small = shortest(root.get(ch), word, idx + 1);
        if(small.length()>0)
            return ch + small;
        
        return "";
        
    }
}
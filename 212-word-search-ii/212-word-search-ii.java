class Solution {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean getEnd(){
            return isEnd;
        }
        
        public void setEnd(){
            isEnd = true;
        }
    }
    
    public void insert(Node curr, String word) {
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);
        
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    
    Node root;
    public static List<String> ans;
    
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        ans = new ArrayList<>();
        for(String word: words){
            insert(root, word);
        }
        
        List<String> dict = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            dict.add(words[i]);
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(i, j, root, "", board, dict);
            }
        }
        
        return ans;
        
    }
    
    public void dfs(int row, int col, Node root, String sof, char[][] board, List<String> dict){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col]=='*' || !root.contains(board[row][col]))
            return;
        
        char ch = board[row][col];
        root = root.get(ch);
        if(root.getEnd() && !ans.contains(sof + ch)){
            ans.add(sof + ch);
        }
        
        // 4 Moves.
        board[row][col] = '*';
        
        dfs(row - 1, col, root, sof + ch, board, dict);
        dfs(row, col - 1, root, sof + ch, board, dict);
        dfs(row + 1, col, root, sof + ch, board, dict);
        dfs(row, col + 1, root, sof + ch, board, dict);
        
        board[row][col] = ch;
        
    }
}
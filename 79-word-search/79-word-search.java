class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean ans = func(i, j, 0, board, word);
                if(ans) return true;
            }
        }
        
        return false;
    }
    
    public boolean func(int row, int col, int idx, char[][] board, String word){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(idx) || board[row][col] == '*')
            return false;
        if(idx == word.length()-1 && board[row][col] == word.charAt(idx))
            return true;
        
        char ch = board[row][col];
        board[row][col] = '*';
        
        boolean ans = false;
        
        boolean ans1 = func(row - 1, col, idx + 1, board, word);
        if(ans1) return true;
        boolean ans2 = func(row, col - 1, idx + 1, board, word);
        if(ans2) return true;
        boolean ans3 = func(row + 1, col, idx + 1, board, word);
        if(ans3) return true;
        boolean ans4 = func(row, col + 1, idx + 1, board, word);
        if(ans4) return true;
        board[row][col] = ch;
        return false;
    }
}
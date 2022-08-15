class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int open = 0, close = 0, count = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
                st.push(ch);
            } else if (ch == ')'){
                if(st.size() > 0){
                    st.pop();
                    open--;
                } else {
                    close++;
                }
            }
        }
        
        return open + close;
    }
}
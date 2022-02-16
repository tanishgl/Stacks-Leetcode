class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int open = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                if(open==0) st.push(i);
                open++;
            } else if (ch==')'){
                if(open>0) open--;
                if(open==0) st.push(i);
            }
        }
        
        StringBuilder sb = new StringBuilder(s);
        while(st.size()>0){
            sb.deleteCharAt(st.pop());
        }
        
        return sb.toString();
    }
}
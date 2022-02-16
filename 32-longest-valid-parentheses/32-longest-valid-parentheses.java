class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch=='('){
                st.push(i);
            } else if (ch==')'){
                if(st.size()>0 && s.charAt(st.peek())=='(')
                    st.pop();
                else st.push(i);
            }
            
            int j = (st.size()==0) ? -1 : st.peek();
            ans = Math.max(ans, i - j);
        }
        
        return ans;
    }
}
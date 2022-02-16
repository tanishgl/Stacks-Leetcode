class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch=='('){
                st.push(i);
            } else if (ch==')'){
                if(st.size()==0 || s.charAt(st.peek())==')'){
                    st.push(i);
                } else {
                    st.pop();
                    if(st.size()>0){
                        ans = Math.max(ans, s.substring(st.peek()+1,i+1).length());
                    } else {
                        ans = Math.max(ans, i+1);
                    }
                }
            }
        }
        
        return ans;
    }
}
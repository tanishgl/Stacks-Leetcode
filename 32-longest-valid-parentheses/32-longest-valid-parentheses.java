class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0, open = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch=='('){
                open++;
                st.push(i);
            } else {
                if(open>0){
                    st.pop();
                    open--;
                } else {
                    st.push(i);
                }
            }
            
            int now_length = (st.size()==0) ? i+1 : i-st.peek();
            ans = Math.max(ans, now_length);
        }
        
        return ans;
    }
}
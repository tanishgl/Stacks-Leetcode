class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int open = 0;
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==')'){
                if(st.size()>0 && open>0){
                    st.pop();
                    open--;
                } else {
                    st.push(i);
                }
            } else {
                // ch = '('
                open++;
                st.push(i);
            }
            
            ans = (st.size()>0) ? Math.max(ans, i-st.peek()) : Math.max(ans, i+1);
        }
        
        return ans;
    }
}
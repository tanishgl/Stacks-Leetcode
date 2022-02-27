class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("#"))
            return true;
        
        String[] arr = preorder.split(",");
        Stack<Character> st = new Stack<>();
        boolean flag = false;
        
        for(String token : arr){
            if(token.equals("#")){
                if(st.size()==0)
                    return false;
                
                if(st.peek()=='l'){
                    st.pop();
                    st.push('r');
                } else {
                    st.pop();
                }
            } else {
                if(st.size()==0){
                    if(!flag){
                        flag = true;
                    } else 
                        return false;
                } else {
                    if(st.peek()=='l'){
                        st.pop();
                        st.push('r');
                    } else {
                        st.pop();
                    }
                }
                
                st.push('l');
            }
        }
        
        if(st.size()==0) return true;
        return false;
    }
}
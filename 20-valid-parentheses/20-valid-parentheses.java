class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            } else if (ch==')' || ch==']' || ch=='}'){
                //check if stack is empty.
                if(st.size()==0){
                    //this is a hanging closing brace with no opening brace.
                    return false;
                }
                
                if(isValidTop(st, ch)){
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        
        //Check if the stack is non-empty.
        if(st.size()!=0){
            //this is a hanging opening brace with no closing brace.
            return false;
        }
        
        return true;
    }
    
    public static boolean isValidTop(Stack<Character> st, char ch){
        if(ch==')' && st.peek()=='('){
            return true;
        } else if (ch==']' && st.peek()=='['){
            return true;
        } else if (ch=='}' && st.peek()=='{'){
            return true;
        } else {
            return false;
        }
    }
}
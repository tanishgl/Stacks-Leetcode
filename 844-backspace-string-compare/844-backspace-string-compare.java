class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='#' && st1.size()>0){
                st1.pop();
            } else if (ch>='a' && ch<='z'){
                st1.push(ch);
            }
        }
        String s1 = "";
        while(st1.size()>0){
            s1 += st1.pop();
        }
        
        Stack<Character> st2 = new Stack<>();
        
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(ch>='a' && ch<='z'){
                st2.push(ch);
            } else if (ch=='#' && st2.size()>0){
                st2.pop();
            }
        }
        String s2 = "";
        while(st2.size()>0){
            s2 += st2.pop();
        }
        
        if(s1.equals(s2)) return true;
        return false;
    }
}
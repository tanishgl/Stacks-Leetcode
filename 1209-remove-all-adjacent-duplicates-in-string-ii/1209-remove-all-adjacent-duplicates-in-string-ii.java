class Solution {
    static class Pair{
        char ch;
        int count;
        Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(s.charAt(0), 1));
        
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.size()>0 && ch == st.peek().ch){
                st.peek().count++;
            } else {
                st.push(new Pair(ch, 1));
            }
            
            if(st.size()>0 && st.peek().count==k)
                st.pop();
        }
        
        String res = "";
        while(st.size()>0){
            Pair pt = st.pop();
            String base = "";
            for(int i=0;i<pt.count;i++){
                base += pt.ch;
            }
            res = base + res;
        }
        
        return res;
    }
}
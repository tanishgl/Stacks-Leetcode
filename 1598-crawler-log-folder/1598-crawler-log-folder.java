class Solution {
    public int minOperations(String[] logs) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(String str : logs){
            if(str.equals("../")){
                if(st.peek()!=0) st.pop();
            } else if (str.equals("./")){
                //do nothing.
            } else {
                st.push(1);
            }
        }
        
        int ans = 0;
        while(st.size()>0 && st.peek()!=0){
            ans++;
            st.pop();
        }
        
        return ans;
    }
}
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        
        for(String str : ops){
            // System.out.println(str);
            if(str.equals("C")){
                st.pop();
            } else if (str.equals("D")){
                st.push(st.peek()*2);
            } else if (str.equals("+")){
                int a = st.pop();
                int b = st.pop();
                int sum = a + b;
                st.push(b);
                st.push(a);
                st.push(sum);
            } else {
                st.push(Integer.parseInt(str));
            }
        }
        
        int sum = 0;
        while(st.size()>0){
            sum += st.pop();
        }
        
        return sum;
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
     
         for(int i=0;i<tokens.length;i++){
             String str = tokens[i];
             char ch = '0';
             if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                 ch = str.charAt(0);
             }
             if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int b = operands.pop();
                int a = operands.pop();
                if(ch == '+'){
                    operands.push(a+b);
                } else if (ch == '-'){
                    operands.push(a-b);
                } else if (ch == '*'){
                    operands.push(a*b);
                } else if (ch == '/'){
                    operands.push(a/b);
                }
             } else {
                 operands.push(Integer.parseInt(str));
             }
         }

         return operands.peek();
    }
}
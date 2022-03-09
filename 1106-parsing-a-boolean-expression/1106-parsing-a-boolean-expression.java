class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operation = new Stack<>();
        Stack<Character> expr = new Stack<>();
        
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch=='('){
                expr.push('(');
            } else if (ch==')'){
                boolean res = (expr.pop() == 't') ? true : false;
                if(operation.peek()=='!'){
                    res = !(res);
                } else {
                    while(expr.size()>0 && expr.peek()!='('){
                        if(operation.peek()=='!'){
                            res = !(res);
                        } else if (operation.peek() == '&') {
                            boolean a = (expr.pop() == 't') ? true : false;
                            res &= a;
                        } else if (operation.peek() == '|') {
                            boolean a = (expr.pop() == 't') ? true : false;
                            res |= a;
                        }
                    }
                }
                
                operation.pop();
                expr.pop();
                expr.push( (res==false) ? 'f' : 't');
            } else if (ch=='!' || ch=='&' || ch=='|'){
                operation.push(ch);
            } else if (ch=='t' || ch=='f'){
                expr.push(ch);
            } else {
                continue;
            }
        }
        
        return (expr.pop() == 't') ? true : false;
    }
}
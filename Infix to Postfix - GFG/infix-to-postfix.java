// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<String> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();
        
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch == '('){
                operator.push(ch);
            } else if (ch >= 'a' && ch <= 'z'){
                operands.push(ch + "");
            } else if (ch == ')'){
                while(operator.size() > 0 && operator.peek() != '('){
                    char op = operator.pop();
                    String b = operands.pop();
                    String a = operands.pop();
                    String postfix = a + b + op;
                    operands.push(postfix);
                }
                // Pop '('
                operator.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){
                while(operator.size() > 0 && precedence(ch) <= precedence(operator.peek()) && operator.peek() != '('){
                    char op = operator.pop();
                    String b = operands.pop();
                    String a = operands.pop();
                    String postfix = a + b + op;
                    operands.push(postfix);
                }
                operator.push(ch);
            }
        }
        
        while(operator.size()>0){
            char op = operator.pop();
            String b = operands.pop();
            String a = operands.pop();
            String postfix = a + b + op;
            operands.push(postfix);
        }
        
        return operands.peek();
    }
    
    public static int precedence(char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        } else if (ch == '*' || ch == '/'){
            return 2;
        } else if (ch == '^'){
            return 3;
        }
        return -1;
    }
}
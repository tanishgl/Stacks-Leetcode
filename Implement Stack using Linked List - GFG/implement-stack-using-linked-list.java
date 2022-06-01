// { Driver Code Starts
import java.util.*;

class StackNode {
    int data;
    StackNode next;
    StackNode(int a) {
        data = a;
        next = null;
    }
}

class GfG {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    obj.push(a);
                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}
// } Driver Code Ends


class MyStack 
{
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }   
    StackNode top;
    StackNode head;
    
    //Function to push an integer into the stack.
    void push(int a) 
    {
        // Stack overflow will never come since it's dynamic.
        StackNode new_node = new StackNode(a);
        top = new_node;
        if(head == null){
            // Stack is empty.
            head = new_node;
        } else {
            StackNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
        if(head == null){
            // stack Underflow
            return -1;
        }
        
        int popped_val = top.data;
        
        if(head.next == null){
            // For one-value stack
            head = null;
            return popped_val;
        }
        
        StackNode prev = null, curr = head;
        
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = null;
        top = prev;
        return popped_val;
    }
}

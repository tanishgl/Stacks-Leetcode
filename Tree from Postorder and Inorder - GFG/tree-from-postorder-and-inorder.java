// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}
// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        return construct(post, in, post.length-1, 0, in.length-1);
    }
    
    public static Node construct(int[] post, int[] ino, int postR, int inoL, int inoR){
        if(inoL > inoR){
            return null;
        }
        
        Node root = new Node(post[postR]);
        
        int idx = find(ino, root.data);
        
        root.left = construct(post, ino, postR - 1 - (inoR-idx), inoL, idx - 1);
        root.right = construct(post, ino, postR-1, idx + 1, inoR);
        return root;
    }
    
    public static int find(int[] arr, int data){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==data){
                return i;
            }
        }
        
        return -1;
    }
}

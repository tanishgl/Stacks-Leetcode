// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        return construct(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    public static Node construct(int[] pre, int[] ino, int preL, int inoL, int inoR){
        if(inoL > inoR){
            return null;
        }
        
        Node root = new Node(pre[preL]);
        
        int idx = find(ino, root.data);
        
        root.left = construct(pre, ino, preL+1, inoL, idx - 1);
        root.right = construct(pre, ino, preL + 1 + (idx - inoL), idx + 1, inoR);
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

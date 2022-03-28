// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    static class Node {
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }
    
    public int[] sortedArrayToBST(int[] nums)
    {
        Node root = construct(nums,0,nums.length-1);
        ArrayList<Integer> res = new ArrayList<>();
        preorder(root,res);
        int[] ans = new int[nums.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    
    public void preorder(Node root, ArrayList<Integer> res){
        if(root==null) return;
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
    
    public Node construct(int[] arr, int l, int r){
        if(l>r) return null;
        int mid = l + (r-l)/2;
        Node root = new Node(arr[mid]);
        root.left = construct(arr,l,mid-1);
        root.right = construct(arr,mid+1,r);
        return root;
    }
}
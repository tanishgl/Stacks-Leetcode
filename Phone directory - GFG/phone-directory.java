// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
       
        public boolean contains(char ch){
            return this.children[ch-'a'] != null;
        }
       
        public Node get(char ch){
            return this.children[ch-'a'];
        }
       
        public void set(char ch){
            this.children[ch-'a'] = new Node();
        }
       
        public boolean getEnd(){
            return this.isEnd;
        }
       
        public void setEnd(){
            this.isEnd = true;
        }
    }
    
    public static void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!curr.contains(ch)){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public static ArrayList<String> search(String str){
        ArrayList<String> res = new ArrayList<>();
        Node curr = root;
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!curr.contains(ch)){
                return res;
            }
            curr = curr.get(ch);
        }
        
        dfs(curr, str, res);
        return res;
    }
    
    public static void dfs(Node curr, String sof, ArrayList<String> res){
        if(curr.getEnd()){
            res.add(sof);
        }
        
        for(char ch = 'a'; ch<='z'; ch++){
            if(curr.contains(ch)){
                dfs(curr.get(ch), sof + ch, res);
            }
        }
    }
   
    static Node root;
    
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        root = new Node();
        for(String str : contact){
            insert(str);
        }
        
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            ArrayList<String> ans = search(s.substring(0,i+1));
            if(ans.size()==0){
                ArrayList<String> base = new ArrayList<>();
                base.add("0");
                res.add(base);
            } else {
                res.add(ans);
            }
        }
        
        return res;
        
    }
}
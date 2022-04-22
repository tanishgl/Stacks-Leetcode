// { Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}// } Driver Code Ends


/*You are required to complete this method */
class GfG
{
   public static class Node {
        private Node[] children = new Node[26];
        private int isEnd = 0;

        public boolean contains(char ch){
            return children[ch-'a'] != null;
        }

        public Node get(char ch){
            return children[ch-'a'];
        }

        public void set(char ch){
            children[ch-'a'] = new Node();
        }

        public int getEnd(){
            return this.isEnd;
        }

        public void setEnd(){
            this.isEnd++;
        }
    }

    public static void insert(String str){
        Node curr = root;
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!curr.contains(ch)){
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
    }

    static Node root;
   public static int countDistinctSubstring(String st)
   {
       root = new Node();
       for(int i=0;i<st.length();i++){
           insert(st.substring(i,st.length()));
       }
       
       return size(root);
   }
   
   public static int size(Node root){
       int ans = 0;
       for(char ch='a';ch<='z';ch++){
           if(root.contains(ch)){
               ans += size(root.get(ch));
           }
       }
       
       return ans + 1;
   }
   
   
}
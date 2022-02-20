class Solution {
    public String toLowerCase(String s) {
        String ans = "";
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch>='a' && ch<='z')
                ans += ch;
            else if (ch>='A' && ch<='Z')
                ans += (char)(ch-'A'+'a');
            else 
                ans += ch;
        }
        
        return ans;
    }
}
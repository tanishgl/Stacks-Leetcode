class Solution {
    public boolean isPalindrome(String s) {
        s = repair(s);
        
        int i = 0, j = s.length()-1;
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
    
    public String repair(String s){
        String ans = "";
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='A' && ch<='Z'){
                ans += (char)(ch+32);
            } else if (ch>='a' && ch<='z'){
                ans += ch;
            } else if (ch>='0' && ch<='9'){
                ans += ch;
            }
        }
        
        return ans;
    }
}
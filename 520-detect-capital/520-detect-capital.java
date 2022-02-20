class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1) return true;
        
        int small = 0, caps = 0;
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            
            if(ch>='a' && ch<='z')
                small++;
            else 
                caps++;
        }
        
        if(caps==word.length())
            return true;
        else if (caps==1 && small==word.length()-1 && word.charAt(0)>='A' && word.charAt(0)<='Z')
            return true;
        else if (small==word.length())
            return true;
    
        return false;
    }
}
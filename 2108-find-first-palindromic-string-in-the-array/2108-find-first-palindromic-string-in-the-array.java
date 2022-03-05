class Solution {
    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(isPal(word))
                return word;
        }
        
        return "";
    }
    
    public boolean isPal(String str){
        int i = 0, j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
}
class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        int mid = (palindrome.length()) / 2;
        String work = palindrome.substring(0, mid);
        
        for(int i=0;i<work.length();i++){
            char ch = work.charAt(i);
            if(ch != 'a'){
                StringBuilder sb = new StringBuilder(work);
                sb.setCharAt(i, 'a');
                return sb.toString() + palindrome.substring(mid);
            }
        }
        
        StringBuilder sb = new StringBuilder(palindrome);
        sb.setCharAt(sb.length()-1, 'b');
        return sb.toString();
        
    }
}
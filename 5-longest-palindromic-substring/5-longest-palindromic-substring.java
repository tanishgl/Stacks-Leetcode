class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        // Expand around the center.
        
        int odd = 0;
        String odds = s.charAt(0) + "";
        
        for(int i=1;i<s.length()-1;i++){
            int l = i - 1, r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > odd){
                    odd = r - l + 1;
                    odds = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }
        
        int even = 0;
        String evens = s.charAt(0) + "";
        
        for(int i=1;i<s.length();i++){
            int l = i - 1, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > even){
                    even = r - l + 1;
                    evens = s.substring(l, r+1);
                }
                l--;
                r++;
            }
        }
        
        if(odds.length() > evens.length())
            return odds;
        else return evens;
    }
}
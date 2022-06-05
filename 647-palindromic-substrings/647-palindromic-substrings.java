class Solution {
    public int countSubstrings(String s) {
        int odd = 0, even = 0;
        
        for(int i=1;i<s.length()-1;i++){
            int l = i - 1, r = i + 1;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                odd++;
                // System.out.println(s.substring(l, r+1));
                l--;
                r++;
            }
        }
        
        for(int i=1;i<s.length();i++){
            int l = i - 1, r = i;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                even++;
                // System.out.println(s.substring(l, r+1));
                l--;
                r++;
            }
        }
        
        return odd + even + s.length();
    }
}
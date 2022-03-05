class Solution {
    public String replaceDigits(String s) {
        String ans = "";
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(i%2==0){
                ans += ch;
            } else {
                char ch2 = (char)(s.charAt(i-1) + (ch-'0'));
                ans += ch2;
            }
        }
        
        return ans;
    }
}
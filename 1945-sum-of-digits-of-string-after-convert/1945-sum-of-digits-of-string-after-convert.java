class Solution {
    public int getLucky(String s, int k) {
        String num = transform(s);
        String ans = "";
        for(int i=0;i<k;i++){
            num = sum(num);
        }
        
        // System.out.println(num);
        return Integer.valueOf(num);
    }
    
    public String transform(String s){
        String ans = "";
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i) - 'a' + 1;
            ans += ch + "";
        }
        
        return ans;
    }
    
    public String transformNumber(String s){
        String ans = "";
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i) - '0';
            ans += ch;
        }
        
        return ans;
    }
    
    public String sum(String s){
        long ans = 0l;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            ans += (ch - '0');
        }
    
        return transformNumber(ans+"");
    }
}
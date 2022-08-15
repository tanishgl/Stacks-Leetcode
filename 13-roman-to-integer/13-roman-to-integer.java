class Solution {
    public int romanToInt(String s) {
        int x = 0;
        for(int i=0;i<s.length();i++){
            int a = calc(s.charAt(i));
            int b = Integer.MIN_VALUE;
            if(i+1 < s.length())
                b = calc(s.charAt(i+1));
            if(a < b){
                x += (b - a);
                i++;
            } else {
                x += a;
            }
                
        }
        
        return x;
    }
    
    public int calc(char ch){
        if(ch == 'I') return 1;
        else if (ch == 'V') return 5;
        else if (ch == 'X') return 10;
        else if (ch == 'L') return 50;
        else if (ch == 'C') return 100;
        else if (ch == 'D') return 500;
        else if (ch == 'M') return 1000;
        return 0;
    }
}
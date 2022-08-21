class Solution {
    public String largestPalindromic(String num) {
        int[] arr = new int[10];
        for(int i=0;i<num.length();i++){
            arr[num.charAt(i)-'0']++;
        }
        String even = "";
        int odd = -1;
        
        for(int i=9;i>=0;i--){
            if(i == 0 && even.length() == 0) break;
            if(arr[i] % 2 == 0)
                even += form(i, arr[i] / 2);
            else {
                int rem = arr[i] - 1;
                if(i > odd){
                    odd = i;
                }
                if(rem > 0) even += form(i, rem / 2);
            }
        }
        
        
        StringBuilder part = new StringBuilder(even);
        if(even.length() == 0 && odd == -1) return "0";
        return (odd != -1) ? even + odd + part.reverse().toString() : even + part.reverse().toString();
    }
    
    public String form(int x , int t){
        String ans = "";
        for(int i=0;i<t;i++){
            ans += x;
        }
        return ans;
    }
}
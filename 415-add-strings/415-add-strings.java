class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        String str = "";
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        
        while(i >= 0 || j >= 0 || carry > 0){
            int d1 = (i>=0) ? num1.charAt(i) - '0' : 0;
            int d2 = (j>=0) ? num2.charAt(j) - '0' : 0;
            int sum = d1 + d2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            str += sum;
            i--;
            j--;
        }
        
        while(i>=0){
            str += num1.charAt(i);
            i--;
        }
        
        while(j>=0){
            str += num2.charAt(j);
            j--;
        }
        
        return new StringBuilder(str).reverse().toString();
    }
}
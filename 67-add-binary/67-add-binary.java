class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        String str = "";
        
        while(i>=0 || j>=0 || carry>0){
            // System.out.println(i + " " + j + " " + carry);
            int bd1 = (i>=0) ? a.charAt(i) - '0' : 0;
            int bd2 = (j>=0) ? b.charAt(j) - '0' : 0;
            int sum = bd1 + bd2 + carry;
            carry = sum / 2;
            sum = sum % 2;
            str += sum;
            i--;
            j--;
        }
        
        return new StringBuilder(str).reverse().toString();
    }
}
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        if(num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        int i = num2.length() - 1, k = 0;
        String totalAns = "";
        
        while(i >= 0){
            int bd = num2.charAt(i) - '0';
            int carry = 0, j = num1.length() - 1;
            String ans = "";
            while(j >=0 || carry > 0){
                int ud = (j >= 0) ? num1.charAt(j) - '0' : 0;
                int mul = ud * bd + carry;
                carry = mul / 10;
                mul = mul % 10;
                ans += mul;
                j--;
            }
            
            ans = new StringBuilder(ans).reverse().toString();
            String app = totalAns.substring(totalAns.length()-k);
            if(totalAns.equals(""))
                totalAns = ans;
            else 
                totalAns = add(totalAns.substring(0,totalAns.length()-k) , ans);
            
            totalAns += app;
            
            // System.out.println(totalAns);
            i--;
            k++;
        }
        
        return totalAns;
    }
    
    public String add(String num1, String num2){
        // System.out.println("num2 = " + num2);
        if(num1.length() == 0) return num2;
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
        
        return new StringBuilder(str).reverse().toString();
    }
}
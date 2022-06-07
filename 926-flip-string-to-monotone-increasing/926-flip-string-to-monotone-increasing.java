class Solution {
    public int minFlipsMonoIncr(String s) {
        int zero = 0, one = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // binary string should end in 0.
            int nz = (ch == '0') ? zero : zero + 1;
            // binary string should end in 1.
            int no = (ch == '1') ? Math.min(zero, one) : Math.min(zero, one) + 1;
            
            zero = nz;
            one = no;
            
            // System.out.println(nz + " " + no + " " + zero + " " + one);
        }
        
        return Math.min(zero, one);
    }
}
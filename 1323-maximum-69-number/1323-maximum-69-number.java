class Solution {
    public int maximum69Number (int num) {
        int nod = (int)Math.log10(num);
        
        for(int i=nod;i>=0;i--){
            int dig = (num / (int)Math.pow(10,i)) % 10;
            if(dig == 6){
                int n = 3 * (int)Math.pow(10, i);
                return num + n;
            }
        }
        
        return num;
    }
}
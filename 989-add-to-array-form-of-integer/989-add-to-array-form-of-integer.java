class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        
        int carry = 0, mul = 1, i = num.length-1, nod = (int)Math.log10(k), j = 0;
        
        while(i >= 0 || j <= nod || carry > 0){
            int d1 = (i >= 0) ? num[i] : 0;
            int d2 = (j <= nod) ? (k / (int)Math.pow(10,j)) % 10 : 0;
            int sum = d1 + d2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            res.add(0, sum);
            i--;
            j++;
        }
        
        return res;
    }
}
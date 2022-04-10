class Solution {
    public String minimizeResult(String expression) {
        int m = expression.indexOf('+');
        String first = expression.substring(0, m);
        String second = expression.substring(m+1);
        int ans = Integer.MAX_VALUE;
        String res = "";
        
        for(int i=0;i<first.length();i++){
            for(int j=0;j<second.length();j++){
                int x = Integer.parseInt(first.substring(i));
                int rx = (first.substring(0,i) == "") ? 1 : Integer.parseInt(first.substring(0,i));
                int y = Integer.parseInt(second.substring(0,j+1));
                int ry = (second.substring(j+1) == "") ? 1 : Integer.parseInt(second.substring(j+1));
                int sum = (x + y) * rx * ry;
                if(sum < ans){
                    res = (i==0) ? "" : rx+"";
                    res += "(" + x + "+" + y + ")";
                    res += (j==second.length()-1) ? "" : ry+"";
                    ans = sum;
                }
                
            }
        }
        
        return res;
    }
}
class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        
        String[] ans = new String[arr.length];
        
        for(int i=0;i<arr.length;i++){
            StringBuilder sb = new StringBuilder(arr[i]);
            ans[sb.charAt(sb.length()-1)-'0'-1] = sb.deleteCharAt(sb.length()-1).toString();
        }
        
        String res = "";
        
        for(int i=0;i<ans.length;i++){
            res += (i==ans.length-1) ? ans[i] : ans[i] + " ";
        }
        
        return res;
        
    }
}
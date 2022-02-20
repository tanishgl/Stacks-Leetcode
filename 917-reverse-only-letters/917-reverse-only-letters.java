class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        int i = 0, j = s.length()-1;
        
        while(i<j){
            if(Character.isLetter(sb.charAt(i))==false){
                i++;
            }
            
            if(Character.isLetter(sb.charAt(j))==false){
                j--;
            }
            
            if(Character.isLetter(sb.charAt(i))==true && Character.isLetter(sb.charAt(j))==true){
                char ch = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, ch);
                i++;
                j--;
            }
        }
        
        return sb.toString();
    }
}
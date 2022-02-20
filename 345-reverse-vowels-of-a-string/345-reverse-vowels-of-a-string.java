class Solution {
    public String reverseVowels(String str) {
        List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        
        int i = 0, j = str.length()-1;
        StringBuilder s = new StringBuilder(str);
        
        while(i<j){
            if(vowels.contains(s.charAt(i))==false){
                i++;
            } 
            
            if(vowels.contains(s.charAt(j))==false){
                j--;
            }
            
            if(vowels.contains(s.charAt(i))==true && vowels.contains(s.charAt(j))==true){
                char ch = s.charAt(i);
                s.setCharAt(i, s.charAt(j));
                s.setCharAt(j, ch);
                i++;
                j--;
            }
        }
        
        return s.toString();
    }
}
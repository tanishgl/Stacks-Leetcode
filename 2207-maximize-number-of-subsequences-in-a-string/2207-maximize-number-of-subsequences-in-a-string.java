class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        //Explore 2 choices.
        
        //Case 1 :- pattern.charAt(0) at the start of the text.
        
        long seen = 1, total = 0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==pattern.charAt(1)) total += seen;
            if(text.charAt(i)==pattern.charAt(0)) seen++;
        }
        
        long seen2 = 1, total2 = 0;
        for(int i=text.length()-1;i>=0;i--){
            if(text.charAt(i)==pattern.charAt(0)) total2 += seen2;
            if(text.charAt(i)==pattern.charAt(1)) seen2++;
        }
        
        return Math.max(total, total2);
    }
}
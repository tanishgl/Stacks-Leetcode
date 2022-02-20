class Solution {
    public char findTheDifference(String s, String t) {
        long sum1 = 0, sum2 = 0;
        
        for(int i=0;i<s.length();i++)
            sum1 += s.charAt(i)-'a';
        
        for(int i=0;i<t.length();i++)
            sum2 += t.charAt(i)-'a';
        
        return (char)(sum2-sum1+'a');
    }
}
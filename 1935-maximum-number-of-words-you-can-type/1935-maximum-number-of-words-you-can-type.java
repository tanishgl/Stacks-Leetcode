class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        ArrayList<Character> broken = new ArrayList<>();
        for(char ch : brokenLetters.toCharArray()){
            broken.add(ch);
        }
        
        String[] arr = text.split(" ");
        int ans = 0;
        for(String str : arr){
            boolean word = true;
            for(Character ch : str.toCharArray()){
                if(broken.contains(ch)==true){
                    word = false;
                    break;
                }
            }
            if(word)
                ans++;
        }
        
        return ans;
    }
}
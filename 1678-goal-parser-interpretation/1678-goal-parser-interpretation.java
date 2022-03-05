class Solution {
    public String interpret(String command) {
        String ans = "";
        for(int i=0;i<command.length();i++){
            char ch = command.charAt(i);
            if(ch=='G'){
                ans += "G";
            } else if (ch=='('){
                //check the next character.
                if(command.charAt(i+1)==')'){
                    ans += "o";
                    i++;
                } else {
                    ans += "al";
                    i += 3;
                }
            }
        }
        
        return ans;
    }
}
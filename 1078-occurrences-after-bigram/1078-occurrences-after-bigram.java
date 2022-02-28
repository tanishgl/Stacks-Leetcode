class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        
        String[] tokens = text.split(" ");
        int i = 0, j = 1;
        
        while(j<tokens.length){
            if(tokens[i].equals(first) && tokens[j].equals(second)){
                if(j+1 < tokens.length)
                    ans.add(tokens[j+1]);
            }
            
            i++;
            j++;
        }
        
        String[] res = new String[ans.size()];
        int idx = 0;
        for(String str : ans)
            res[idx++] = str;
        
        return res;
    }
}
class Encrypter {
    
    HashMap<Character, String> hm = new HashMap<>();
    HashMap<String, Integer> map = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for(int i=0;i<keys.length;i++){
            hm.put(keys[i], values[i]);
        }
        
        for(int i=0;i<dictionary.length;i++){
            map.put(encrypt(dictionary[i]), map.getOrDefault(encrypt(dictionary[i]), 0) + 1);
        }
        
        System.out.println(map);
    }
    
    public String encrypt(String word1) {
        String ans = "";
        for(int i=0;i<word1.length();i++){
            ans += hm.getOrDefault(word1.charAt(i), "#");
        }
        
        return ans;
    }
    
    public int decrypt(String word2) {
        if(word2 == null) return 0;
        return map.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
class Solution {
    public long appealSum(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int next = 1;
        map.put(s.charAt(n-1), 1);
        int count = 1;
        long res = 1l;
        
        for(int i=n-2;i>=0;i--){
            int ans = 1 + count + next;
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                ans -= map.get(ch);
            }
            count++;
            map.put(ch, count);
            next = ans;
            res += next;
        }
        
        return res;
    }
}
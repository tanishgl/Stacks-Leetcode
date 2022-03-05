class Solution {
    public String truncateSentence(String s, int k) {
        Deque<String> dq = new ArrayDeque<>();
        
        String[] arr = s.split(" ");
        int idx = 0;
        while(k-->0){
            dq.addLast(arr[idx++]);
        }
        
        String ans = "";
        while(dq.size()>0){
            ans += (dq.size()==1) ? dq.removeLast() : dq.removeFirst() + " ";
        }
        
        return ans;
    }
}
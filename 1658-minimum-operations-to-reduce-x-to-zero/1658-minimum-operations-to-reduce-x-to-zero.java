class Solution {
    public int minOperations(int[] arr, int x) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        
        int val = prefix[n-1] - x;
        if(val == 0) return n;
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int target = prefix[i] - val;
            if(map.containsKey(target)){
                maxLen = Math.max(maxLen, i - map.get(target));
                // System.out.println(i + " " + map.get(target));
            }
            if(!map.containsKey(prefix[i])) map.put(prefix[i],i);
        }
        
        return (maxLen != Integer.MIN_VALUE) ? n - maxLen : -1;
    }
}
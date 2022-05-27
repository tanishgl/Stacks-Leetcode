class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        
        // Now the envelopes are sorted based on length. Now, only requirement is to apply LIS based on width. 
        
        int n = envelopes.length;
        List<Integer> packets = new ArrayList<>();
        packets.add(envelopes[0][1]);
        
        for(int i=1;i<n;i++){
            if(envelopes[i][1] > packets.get(packets.size()-1)){
                packets.add(envelopes[i][1]);
            } else {
                int idx = lowerBound(packets, envelopes[i][1]);
                packets.set(idx, envelopes[i][1]);
            }
        }
        
        return packets.size();
    }
    
    public int lowerBound(List<Integer> arr, int target){
        int lo = 0, hi = arr.size()-1;
        int idx = arr.size();
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr.get(mid) >= target){
                idx = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return idx;
    }
}
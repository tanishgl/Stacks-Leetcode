class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            max = Math.max(max,candies[i]);
        }
        
        int lo = 0, hi = max, ans = 0;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(isPossible(candies,mid,k)){
                ans = mid;
                System.out.println("ans");
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return ans;
    }
    
    public boolean isPossible(int[] arr, int mid, long k){
        //System.out.println(mid);
        if(mid==0) return true;
        long n = 0;
        for(int i=0;i<arr.length;i++){
            if(mid!=0)
                n += arr[i]/mid;
        }
        System.out.println(mid + " " + n);
        if(n<k) return false;
        return true;
    }
}
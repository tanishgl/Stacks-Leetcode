class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        
        int[] ptr = new int[primes.length];
        Arrays.fill(ptr, 1);
        
        List<Integer> ugly = new ArrayList<>();
        ugly.add(-1);
        ugly.add(1);
        
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for(int j=0;j<ptr.length;j++){
                int x = ugly.get(ptr[j]) * primes[j];
                if(x <= min){
                    min = x;
                    idx = j;
                }
            }
            
            ugly.add(min);
            
            for(int j=0;j<ptr.length;j++){
                if(ugly.get(ptr[j])*primes[j] == min){
                    ptr[j]++;
                }
            }
        }
        
        return ugly.get(n);
        
    }
}
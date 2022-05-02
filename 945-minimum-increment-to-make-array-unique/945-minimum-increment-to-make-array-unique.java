class Solution {
    private static int SZ = 1000001;
    
    public int minIncrementForUnique(int[] nums) {
        int[] arr = new int[SZ];
        
        for(int val : nums){
            arr[val]++;
        }
        
        int count = 0;
        for(int i=0;i<SZ;i++){
            if(arr[i]<=1)
                continue;
            int extra_freq = arr[i] - 1;
            arr[i+1] += extra_freq;
            count += extra_freq;
        }
        
        return count;
    }
}
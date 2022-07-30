class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] rlis = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(rlis, 1);
        
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[i] > nums[j])
                    rlis[i] = Math.max(rlis[i], rlis[j] + 1);
            }
        }
        
        int ans = 0;
        
        for(int i=1;i<n-1;i++){
            if(lis[i] > 1 && rlis[i] > 1)
                ans = Math.max(ans, lis[i] + rlis[i] - 1);
        }
        
        return n - ans;
    }
}
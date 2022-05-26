class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] inc = new int[n];
        int[] dec = new int[n];
        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        int maxL = 1;
        
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i] == nums[j])
                    continue;
                if(nums[i] > nums[j]){
                    inc[i] = Math.max(inc[i], dec[j] + 1);
                } else {
                    dec[i] = Math.max(dec[i], inc[j] + 1);
                }
            }
            maxL = Math.max(maxL, Math.max(inc[i], dec[i]));
        }
        
        return maxL;
    }
}
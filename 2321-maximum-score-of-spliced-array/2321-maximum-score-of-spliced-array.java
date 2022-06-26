class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int s1 = 0, s2 = 0, n = nums1.length;
        for(int i=0;i<n;i++){
            s1 += nums1[i];
            s2 += nums2[i];
        }
        
        int ans = Math.max(s1, s2);
        int curr = 0, max = 0;
        
        for(int i=0;i<n;i++){
            curr = Math.max(curr + nums2[i] - nums1[i], nums2[i] - nums1[i]);
            max = Math.max(curr, max);
        }
        
        ans = Math.max(ans, s1 + max);
        
        curr = 0; max = 0;
        for(int i=0;i<n;i++){
            curr = Math.max(curr + nums1[i] - nums2[i], nums1[i] - nums2[i]);
            max = Math.max(max, curr);
        }
        
        ans = Math.max(ans, s2 + max);
        
        return ans;
    }
}
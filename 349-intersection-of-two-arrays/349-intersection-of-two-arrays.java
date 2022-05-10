class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i], true);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])){
                res.add(nums2[i]);
                map.put(nums2[i], false);
            }
        }
        
        int[] ans = new int[res.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<nums1.length;i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i], 1);
            }
        }
        
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) == 1 && !ans.contains(nums2[i])){
                ans.add(nums2[i]);
            } else {
                map.put(nums2[i], 2);
            }
        }
        
        for(int i=0;i<nums3.length;i++){
            if(map.containsKey(nums3[i]) && !ans.contains(nums3[i])){
                ans.add(nums3[i]);
            }
        }
        
        return ans;
    }
}
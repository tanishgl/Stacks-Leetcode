class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums2.length > nums1.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        nums1 = filter(nums1);
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<nums1.length;i++){
            if(exists(nums2, nums1[i])==true){
                ans.add(nums1[i]);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    public static boolean exists(int[] arr, int target){
        Arrays.sort(arr);
        int l = 0, r = arr.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid] == target){
                return true;
            } else if (arr[mid]>target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return false;
    }
    
    public static int[] filter(int[] arr){
        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i==0 || arr[i]!=arr[i-1]){
                ans.add(arr[i]);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}
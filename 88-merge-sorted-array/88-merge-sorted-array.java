class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        for(int i=m;i<m+n;i++){
            nums1[i] = nums2[i-m];
        }
        
        /* Approach for merge sort with constant space */
        
//         for(int i=m;i<nums1.length;i++){
//             int card = nums1[i];
//             int j = i - 1;
//             while(j>=0 && nums1[j]>card){
//                     nums1[j+1] = nums1[j];
//                     j--;
//             }
            
//             nums1[j+1] = card;
//         }
        
        /* Shell Sort */
        
        for(double gap=(n+m)/2.0;gap>0;gap= gap/2.0){
            int jstart = (int)Math.ceil(gap);
            for(int i=0,j=jstart;j<m+n;i++,j++){
                if(nums1[i]>nums1[j]){
                    swap(nums1, i , j);
                }
            }
            if(jstart==1) break;
        }
        
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
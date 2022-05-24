class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int ans = 0;
        
        for(int i=0;i<n;i++){
            if(i > 0 && i < n - 1 && arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                int left = i-1, right = i+1, curr = 0;
                while(left >= 0 && arr[left] < arr[left+1]){
                    left--;
                    curr++;
                }
                
                while(right < n && arr[right] < arr[right-1]){
                    right++;
                    curr++;
                }
                
                ans = Math.max(ans, curr + 1);
            }
        }
        
        return ans;
    }
}
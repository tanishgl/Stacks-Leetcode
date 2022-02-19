class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(i==0)
                arr[i] = arr[i];
            else 
                arr[i] = arr[i] + arr[i-1];
        }
        
        if(arr[arr.length-1]==0){
            int count = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==0)
                    count++;
            }
            
            if(count<3) return false;
            else return true;
        }
        
        int sum = arr[arr.length-1];
        boolean[] vis = new boolean[2];
        int[] index = new int[2];
        
        if(sum%3==0){
            int sum1 = arr[arr.length-1] / 3;
            int sum2 = sum1 * 2;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==sum1 && vis[0]==false){
                    index[0] = i;
                    vis[0] = true;
                } else if (arr[i]==sum2){
                    index[1] = i;
                    vis[1] = true;
                }
            }
            
            if(index[0] < index[1] && vis[0] && vis[1]){
                return true;
            }
        } 
        
        return false;
    }
}
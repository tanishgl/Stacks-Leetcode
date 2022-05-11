class Solution {
    public int countVowelStrings(int n) {
        if(n==1) return 5;
        int[] arr = {1,1,1,1,1};
        for(int i=2;i<n;i++){
            for(int j=1;j<5;j++){
                arr[j] += arr[j-1];
            }
        }
        
        return (arr[0]*5 + arr[1]*4 + arr[2]*3 + arr[3]*2 + arr[4]);
    }
}
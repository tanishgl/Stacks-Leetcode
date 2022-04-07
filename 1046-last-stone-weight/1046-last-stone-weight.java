class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int j = stones.length - 1;
        int i = j - 1;
        while(i>=0 && j>=0){
            if(stones[i]==stones[j]){
                i-=2;
                j-=2;
            } else {
                stones[i] = stones[j] - stones[i];
                insertionSort(stones, i);
                i-=1;
                j-=1;
            }
        }
        
        return (j>=0) ? stones[j] : 0;
        
    }
    
    public void insertionSort(int[] arr, int n){
        int card = arr[n];
        int j = n;
        while(j>0 && card < arr[j-1]){
            arr[j] = arr[j-1];
            j--;
        }
        arr[j] = card;
    }
}
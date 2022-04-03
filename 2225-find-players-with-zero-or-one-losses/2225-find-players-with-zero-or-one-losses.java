class Solution {
    // public List<List<Integer>> findWinners(int[][] matches) {
//         List<Integer> win = new ArrayList<>();
//         List<Integer> lost = new ArrayList<>();
//         List<Integer> bl = new ArrayList<>();
        
//         for(int i=0;i<matches.length;i++){
//             if(win.contains(matches[i][0])==false && bl.contains(matches[i][0])==false && lost.contains(matches[i][0])==false){
//                 win.add(matches[i][0]);
//             }
            
//             if(win.contains(matches[i][1])==true){
//                 win.remove(new Integer(matches[i][1]));
//             }
            
//             if(lost.contains(matches[i][1])==false && bl.contains(matches[i][1])==false){
//                 lost.add(matches[i][1]);
//             } else {
//                 lost.remove(new Integer(matches[i][1]));
//                 bl.add(matches[i][1]);
//             }
//         }
        
//         Collections.sort(win);
//         Collections.sort(lost);
//         // System.out.println(win);
//         // System.out.println(lost);
        
//         List<List<Integer>> ans = new ArrayList<>();
//         ans.add(win);
//         ans.add(lost);
        
//         return ans;
//     }
    
    public List<List<Integer>> findWinners(int[][] matches){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<matches.length;i++){
            max = Math.max(max,Math.max(matches[i][0],matches[i][1]));
        }
        
        int[] arr = new int[max];
        for(int i=0;i<matches.length;i++){
            int winner = matches[i][0];
            if(arr[winner-1]>=0) arr[winner-1]++;
            int lost = matches[i][1];
            if(arr[lost-1]>=0)
                arr[lost-1] = -1;
            else arr[lost-1]--;
        }
        
        List<Integer> wins = new ArrayList<>();
        List<Integer> lost = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0) wins.add(i+1);
            else if (arr[i]==-1) lost.add(i+1);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(wins);
        ans.add(lost);
        return ans;
    }
}
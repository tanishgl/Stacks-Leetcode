class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = Integer.MAX_VALUE;
        //Case 1 :- First row is tops[0].
        int a = 0;
        boolean top = true;
        for(int i=1;i<tops.length;i++){
            if(top ==true && tops[i]!=tops[0]){
                if(bottoms[i]==tops[0]){
                    a++;
                } else {
                    top = false;
                }
            }
        }
        
        if(top) ans = Math.min(ans,a);
        
        //Case 2 :- First row is all bottoms[0].
        int b = 1;
        top = true;
        for(int i=1;i<tops.length;i++){
            if(top == true && tops[i]!=bottoms[0]){
                if(bottoms[i]==bottoms[0]){
                    b++;
                } else {
                    top = false;
                }
            }
        }
        
        if(top) ans = Math.min(ans,b);
        
        //Case 3 :- Second row is all tops[0].
        int c = 1;
        boolean bot = true;
        for(int i=1;i<bottoms.length;i++){
            if(bot==true && bottoms[i]!=tops[0]){
                if(tops[i]==tops[0]){
                    c++;
                } else {
                    bot = false;
                }
            }
        }
        
        if(bot) ans = Math.min(ans,c);
        
        //Case 4 :- Second row is all bottoms[0].
        int d = 0;
        bot = true;
        for(int i=1;i<bottoms.length;i++){
            if(bot==true && bottoms[i]!=bottoms[0]){
                if(tops[i]==bottoms[0]){
                    d++;
                } else {
                    bot = false;
                }
            }
        }
        
        if(bot) ans = Math.min(ans,d);
        
        return (ans!=Integer.MAX_VALUE) ? ans : -1;
    }
}
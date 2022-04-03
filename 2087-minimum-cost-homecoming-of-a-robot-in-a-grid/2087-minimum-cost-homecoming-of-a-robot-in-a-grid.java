class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int totalCost = 0;
        
        //Case 1 :- Destination row is greater than source row.
        
        if(homePos[0] >= startPos[0]){
            for(int i=startPos[0]+1;i<=homePos[0];i++)
                totalCost += rowCosts[i];
        } else {
            for(int i=startPos[0]-1;i>=homePos[0];i--)
                totalCost += rowCosts[i];
        }
        
        if(homePos[1] >= startPos[1]){
            for(int i=startPos[1]+1;i<=homePos[1];i++)
                totalCost += colCosts[i];
        } else {
            for(int i=startPos[1]-1;i>=homePos[1];i--)
                totalCost += colCosts[i];
        }
        
        return totalCost;
        
    }
}
// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        
        Arrays.sort(arr, new Comparator<Item>() {
            public int compare(Item a, Item b){
                double r1 = (double)a.value / (double)a.weight;
                double r2 = (double)b.value / (double)b.weight;
                return Double.compare(r2, r1);
            }
        });
        
        double ans = 0.0;
        int item = 0;
        
        while(item < n && W>0){
            if(arr[item].weight <= W){
                ans += arr[item].value;
                W -= arr[item].weight;
            } else {
                double amount = (double) (arr[item].value * W) / (double) arr[item].weight;
                ans += amount;
                W = 0;
            }
            item++;
            // System.out.println(W + " " + ans);
        }
        
        return ans;
        
    }
}
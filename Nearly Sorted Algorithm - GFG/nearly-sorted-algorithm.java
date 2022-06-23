/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    
	    Scanner in = new Scanner(System.in);
	    int T = in.nextInt();
	    while(T-- > 0){
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] arr = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = in.nextInt();
	        }
	        
	        //code
		    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		    ArrayList<Integer> res = new ArrayList<>();
		    
		    for(int i=0;i<n;i++){
		        if(minHeap.size() < k){
		            minHeap.add(arr[i]);
		        } else {
		            int lp = minHeap.peek();
		            if(lp <= arr[i]){
		                res.add(minHeap.remove());
		                minHeap.add(arr[i]);
		            } else {
		                res.add(arr[i]);
		            }
		        }
		    }
		    
		    while(minHeap.size()>0){
		        res.add(minHeap.remove());
		    }
		    
		    for(int i=0;i<n;i++){
		        System.out.print(res.get(i) + " ");
		    }
		    System.out.println();
	        
	    }
		
	}
}
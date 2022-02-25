class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        
        int max = Math.max(arr1.length, arr2.length);
        
        int[] a = new int[max];
        int[] b = new int[max];
        
        for(int i=0;i<arr1.length;i++){
            a[i] = Integer.parseInt(arr1[i].trim());
        }
        
        for(int i=0;i<arr2.length;i++){
            b[i] = Integer.parseInt(arr2[i].trim());
        }
        
        for(int i=0;i<max;i++){
            if(a[i]>b[i])
                return 1;
            else if (a[i]<b[i])
                return -1;
        }
        
        return 0;
        
        
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        List<List<String>> res = new ArrayList<>();
        String prefix = "";
        for(char ch : searchWord.toCharArray()){
            prefix += ch;
            res.add(binarySearch(prefix, products));
        }
        
        return res;
    }
    
    public List<String> binarySearch(String prefix, String[] products){
        int l = 0, h = products.length-1;
        int ans = 0;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(prefix.compareTo(products[mid]) <= 0){
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        List<String> res = new ArrayList<>();
        
        int i = ans;
        
        while(i<products.length && res.size() < 3 && prefix.compareTo( products[i].substring(0, Math.min(prefix.length(), products[i].length() ) ) ) == 0){
            res.add(products[i]);
            i++;
        }
        
        return res;
    }
}
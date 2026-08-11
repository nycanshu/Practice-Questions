class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> hm = new HashMap<>();

        for( String str : arr){
            
            hm.put(str, hm.getOrDefault(str,0)+1);
    
        }

        //hashmap does not have fixed ordering so we can't traverse into it. 

        for(String val : arr){
            if(hm.get(val) == 1){
                k--;

                if( k == 0){
                    return val;
                }
            }
        }

        return "";
    }
}
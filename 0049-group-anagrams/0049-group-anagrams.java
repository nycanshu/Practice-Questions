class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> hm = new HashMap<>();

        for( String str : strs){

            //convert into arrays to sort
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);

            //store sorted to a string for KEY
            String key = new String(strArr);

            //if key not exists create a arraylist for mapping
            if(!hm.containsKey(key)){
                hm.put(key, new ArrayList<>());
            }

            hm.get(key).add(str);
        }

        return new ArrayList<>(hm.values());
    }
}
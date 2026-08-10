class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for( int i = 0;i< strs.length; i++){

            char[] curr = strs[i].toCharArray();
            
            Arrays.sort(curr); 
            String key = new String(curr);

            if( map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
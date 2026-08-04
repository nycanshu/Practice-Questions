class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String small = strs[0];
        String large = strs[strs.length-1];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<small.length() && i<large.length(); i++){
            if(small.charAt(i)!=large.charAt(i)){
                return sb.toString();
            }
            sb.append(small.charAt(i));
        }
        return sb.toString();
    }
}
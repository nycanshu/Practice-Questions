class Solution {
    public int firstUniqChar(String s) {
        int[] words = new int[26];
        

        for(int i=0;i<s.length();i++){
            words[s.charAt(i) - 'a']++;
        }   

        for(int i=0;i<s.length();i++){
            if(words[s.charAt(i) - 'a'] == 1){
                return i;
            }
        } 
        return -1;
    }
}
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] allowedArr = new int[26];

        for(char ch : allowed.toCharArray()){
            allowedArr[ch - 'a']++;
        }

        int result = 0;
        for( String word : words){
            if(canBeFormed(allowedArr, word)){
                result ++;
            }
        }

        return result;
    }

    public static boolean canBeFormed(int[] allowedArr, String word){

        for( char ch : word.toCharArray()){
            
            if(allowedArr[ch - 'a'] == 0) return false;

           

        }

        return true;
    }
}
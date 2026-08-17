class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] allowedArr = new int[26];

        for(char ch : allowed.toCharArray()){
            allowedArr[ch - 'a']++;
        }

        //if problem say all char mapp like aa to aa means 2a then clone array and then pass for canBeFormed so that it wont update in place.

        int result = 0;
        for( String word : words){
            int[] temp = allowedArr.clone();
            if(canBeFormed(temp, word)){
                result ++;
            }
        }

        return result;
    }

    public static boolean canBeFormed(int[] allowedArr, String word){

        for( char ch : word.toCharArray()){
            
            if(allowedArr[ch - 'a'] == 0) return false;

           //if case says that unique maps then reduce to count
           // allowedArr[ch - 'a'] --;

        }

        return true;
    }
}
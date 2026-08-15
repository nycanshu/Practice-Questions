class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int[] countArray = new int[26];

        for(char ch : chars.toCharArray()){
            countArray[ch - 'a']++;
        }

        int result = 0;
        for(int i =0 ;i<words.length;i++){
            //if words[i] can be formed in countArray or not

            if(canBeFormed(words[i],countArray)){
                result += words[i].length();
            }
        }
        return result;
    }

    public static boolean canBeFormed(String word, int[] countArray){

        //temp charcountarry for word
        int[] tempchar = new int[26];

        for(int i=0;i<word.length();i++){

            char ch = word.charAt(i);
            tempchar[ch - 'a']++;

            if(tempchar[ch - 'a'] > countArray[ch - 'a']){
                return false;
            }
        }
        return true;

    }



}
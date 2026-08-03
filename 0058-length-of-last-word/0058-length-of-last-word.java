class Solution {
    public int lengthOfLastWord(String s) {
       
       s.trim();

       String[] words = words = s.split(" ");

       

       return words[words.length-1].length();
    }
}
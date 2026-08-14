class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if(pattern.length() != words.length)
            return false;

        Map<Object, Integer> map = new HashMap<>();

        /*
         * Intuition:
         *
         * For a valid pattern, the repetition structure of characters
         * and words must be identical.
         *
         * Example:
         * pattern = "abba"
         * words   = "dog cat cat dog"
         *
         * Previous occurrence indexes:
         *
         * a -> null, dog -> null
         * b -> null, cat -> null
         * b -> 1,    cat -> 1
         * a -> 0,    dog -> 0
         *
         * At every position, the character and word must have been
         * seen previously at the same index.
         *
         * map.put(key, i) returns the old value associated with key.
         * If the old values differ, the pattern mapping is invalid.
         *
         * We use Map<Object, Integer> so that both Character and String
         * keys can be stored in the same map.
         */
        for(int i = 0; i < pattern.length(); i++) {
            if(!Objects.equals(
                    map.put(pattern.charAt(i), i),
                    map.put(words[i], i)
            )) {
                return false;
            }
        }

        return true;
    }
}
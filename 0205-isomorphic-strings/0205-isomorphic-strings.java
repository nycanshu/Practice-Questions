class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> sTot = new HashMap<>();
        HashMap<Character, Character> tTos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (sTot.containsKey(ch1)) {
                if (sTot.get(ch1) != ch2) {
                    return false;
                }
            } else {

                sTot.put(ch1, ch2);
            }

            //same same logic to now tTos map

            if (tTos.containsKey(ch2)) {
                if (tTos.get(ch2) != ch1) {
                    return false;
                }
            } else {
                tTos.put(ch2, ch1);
            }

        }

        return true;
    }
}
class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;

        // Stores the last seen position (index + 1) of each character.
        int[] lastSeenInSource = new int[256];
        int[] lastSeenInTarget = new int[256];

        for (int index = 0; index < s.length(); index++) {

            char sourceChar = s.charAt(index);
            char targetChar = t.charAt(index);

            // The history of both characters must match.
            if (lastSeenInSource[sourceChar] != lastSeenInTarget[targetChar]) {
                return false;
            }

            // Record that we saw both characters at this position.
            lastSeenInSource[sourceChar] = index + 1;
            lastSeenInTarget[targetChar] = index + 1;
        }

        return true;
    }
}
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {

        int[] first = new int[26];
        Arrays.fill(first, -1);

        int ans = -1;

        for (int i = 0; i < s.length(); i++) {

            int index = s.charAt(i) - 'a';

            if (first[index] == -1) {
                first[index] = i;
            } else {
                ans = Math.max(ans, i - first[index] - 1);
            }
        }

        return ans;
    }
}
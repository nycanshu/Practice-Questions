class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        int minEven = Integer.MAX_VALUE;
        int maxOdd = 0;

        for (int val : arr) {

            if (val == 0)
                continue;

            if (val % 2 == 0) {
                minEven = Math.min(minEven, val);
            } else {
                maxOdd = Math.max(maxOdd, val);
            }
        }

        return maxOdd - minEven;
    }
}
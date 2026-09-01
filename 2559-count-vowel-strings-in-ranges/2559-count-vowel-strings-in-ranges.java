class Solution {

    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;

        // prefix[i] = number of vowel strings before index i
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {

            prefix[i + 1] = prefix[i];

            if (startsAndEndsWithVowel(words[i])) {
                prefix[i + 1]++;
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int start = queries[i][0];
            int end = queries[i][1];

            answer[i] = prefix[end + 1] - prefix[start];
        }

        return answer;
    }

    private boolean startsAndEndsWithVowel(String word) {

        String vowels = "aeiou";

        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);

        return vowels.indexOf(first) != -1
            && vowels.indexOf(last) != -1;
    }
}
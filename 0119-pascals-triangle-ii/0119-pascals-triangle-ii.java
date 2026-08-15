class Solution {
    public List<Integer> getRow(int rowIndex) {

        int[][] pascal = new int[rowIndex + 1][rowIndex + 1];

        for (int i = 0; i <= rowIndex; i++) {

            // First and last element of every row
            pascal[i][0] = 1;
            pascal[i][i] = 1;

            // Calculate middle elements
            for (int j = 1; j < i; j++) {
                pascal[i][j] =
                    pascal[i - 1][j - 1] +
                    pascal[i - 1][j];
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int j = 0; j <= rowIndex; j++) {
            result.add(pascal[rowIndex][j]);
        }

        return result;
    }
}
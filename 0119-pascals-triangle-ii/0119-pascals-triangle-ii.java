class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();

        // Every Pascal row starts with 1
        row.add(1);

        // Build each next row
        for (int currentRow = 1; currentRow <= rowIndex; currentRow++) {

            // Every Pascal row ends with 1
            row.add(1);

            // Update middle elements from right to left
            for (int position = currentRow - 1; position > 0; position--) {
                row.set(
                    position,
                    row.get(position - 1) + row.get(position)
                );
            }
        }

        return row;
    }
}
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        //edge case 
        if(numRows == 0){
            return ans;
        }

        // first row is always 1 
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);

        //edge case which is known that first one has one only
        if(numRows == 1) return ans;

        //now the main loops to generate the logic
        for(int i=1;i<numRows ;i++){

            //store prev row to calculate values
            List<Integer> prevRow = ans.get(i-1);

            //temp row as current row for adding
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); //each row starts with 1 so adding

            for(int j=0;j< i-1;j++){
                currentRow.add(prevRow.get(j) + prevRow.get(j+1));
            }

            //each row ends with 1
            currentRow.add(1);

            ans.add(currentRow);

        }

        return ans;
        
    }
}
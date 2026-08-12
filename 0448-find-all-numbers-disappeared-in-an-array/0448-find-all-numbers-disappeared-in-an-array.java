class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //inplace replacement method
        //traverse to the array nums and make the ith values as negative saying that it is seen(negavtice)
        // for nums[5] we will mark the 5th values which is 4th index as seen means -gative. 

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            
            //get val of i and mark ith val as negavtive (it will be 1 less as it is 0 indexed)
            int idx = Math.abs(nums[i]) - 1;


            //if curr val is negavite means it is there
            if(nums[idx] < 0){
                continue;
            }

            

           
            nums[idx] = -1 * nums[idx];

        }

        //check the array for postive if there add its position which is index+1

        for(int i=0;i<nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list; 
    }
}
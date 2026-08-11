class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;

        for(int num : nums){
            rightSum += num;
        }

        //traverse into arrray and calclate
        // remove current element from right sum = left sum or not 
        for(int i =0;i<nums.length;i++){

            rightSum -= nums[i];

            if( rightSum == leftSum){
                return i;
            }
            
            //add curr to left sum to make it accurate
            leftSum += nums[i];

        } 
        return -1;

    }
}
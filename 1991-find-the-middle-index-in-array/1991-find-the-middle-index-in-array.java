class Solution {
    public int findMiddleIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for( int num : nums){
            rightSum += num;
        }

        for( int i=0;i < nums.length; i++){
            
            rightSum -= nums[i];

            if(rightSum == leftSum) {
                return i;
            }

            leftSum += nums[i];
        }
        return -1;
    }
}
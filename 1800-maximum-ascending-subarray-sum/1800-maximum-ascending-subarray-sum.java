class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];

        for( int i=0;i<nums.length-1;i++){
            if(nums[i+1] > nums [i]){
                sum += nums[i+1];
            }else{
                sum = nums[i+1];
            }

            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
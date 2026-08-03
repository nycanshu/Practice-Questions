class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            
            if(nums[i] == 1){
                count++;
               maxCount = Math.max(maxCount, count);
               
            }else{
                count=0;
            }
        }
        return maxCount;
    }
}
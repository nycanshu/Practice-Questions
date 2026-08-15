class Solution {
    public boolean isMonotonic(int[] nums) {

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i - 1]) {
                increasing = false;
            }

            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            }

            if(!increasing && !decreasing){
                return false;
            }
        }

        return increasing || decreasing;
    }
}
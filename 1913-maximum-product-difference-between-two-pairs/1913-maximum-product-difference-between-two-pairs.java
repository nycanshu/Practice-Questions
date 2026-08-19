class Solution {
    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int lowLow = nums[0];
        int lowHigh = nums[1];
        int highLow = nums[n - 2];
        int highHigh = nums[n - 1];

        return (highLow * highHigh) - (lowLow * lowHigh);
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];

            if (hm.containsKey(val)) {
                return new int[]{hm.get(val), i};
            }

            hm.put(nums[i], i);
        }

        return new int[]{};
    }
}
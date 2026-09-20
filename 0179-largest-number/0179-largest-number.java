class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        // Convert to strings once.
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Core comparator:
        // a comes before b if (a+b) is lexicographically larger than (b+a).
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // All-zero case.
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}
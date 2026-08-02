class Solution {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        int maxRight = -1;
        for(int i=arr.length - 1 ; i>=0 ;i--){
            ans[i] = maxRight;
            maxRight = Math.max(maxRight, arr[i]);
        }

        return ans;
    }
}
class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[501];

        for(int val : arr){
            count[val]++;
        }
        

        for(int i=count.length-1;i>=1;i--){
            if(count[i] == i){
                return count[i];
            }
        }

        return -1;
    }
}
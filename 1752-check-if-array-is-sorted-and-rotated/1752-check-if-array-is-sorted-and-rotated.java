class Solution {
    public boolean check(int[] nums) {
        //is it has o breakpoint means not rotated and one break point then rotated
        //if more than 1 means break array
        //breakpoint = arr[i] > arr[(i+1)%n]

        int isUp = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){

            if(nums[i] > nums[(i+1)%n]){
                isUp++;
                
            }

        }
        return isUp<=1;
    }
}
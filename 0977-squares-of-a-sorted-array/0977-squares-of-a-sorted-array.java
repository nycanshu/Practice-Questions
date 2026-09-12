class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0,right=nums.length-1,i=nums.length-1;
        int arr[] = new int[nums.length];
        while(left<=right)
        {
            if(Math.abs(nums[left])>Math.abs(nums[right]))
            {
                arr[i] = nums[left]*nums[left];
                
                left++;
            }
            else
            {
                arr[i] = nums[right]*nums[right];
                
                right--;
            }
            i--;
        }

        return arr;
    }
}
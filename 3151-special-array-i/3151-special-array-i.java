class Solution {
    public boolean isArraySpecial(int[] nums) {
        //using xor approch 

        for(int i=1;i<nums.length;i++){
            int prev = nums[i-1];
            int curr = nums[i];

            if(((prev ^ curr) & 1) == 0){
                return false;
            }
            
        }
        return true;
    }
}
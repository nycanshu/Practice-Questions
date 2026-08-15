class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int num : nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }

        //claculate the freq of each num;
        for( int val : hm.values()){
            if((val & 1) == 1){
                return false;
            }
        }

        return true;
    }
}
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<nums2.length;i++){

            int greater = -1;
            for(int j=i+1;j<nums2.length;j++){
                
                if(nums2[j]> nums2[i]){
                    greater = nums2[j];
                    break;
                }
            }
            hm.put(nums2[i],greater);
        }

        int[] ans = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            ans[i] = hm.get(nums1[i]);
        }

        return ans;
    }
}
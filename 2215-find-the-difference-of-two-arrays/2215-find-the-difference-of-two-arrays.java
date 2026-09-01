class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        List<List<Integer>> ans = new ArrayList<>();

        for(int num : nums1){
            set1.add(num);
        }
        for(int num: nums2){
            set2.add(num);
        }

        //check for each arrays and insert 
        
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int num : set1){
            
            if(!set2.contains(num)){
                list1.add(num);
            }
        }
        ans.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        for(int num : set2){
            
            if(!set1.contains(num)){
                list2.add(num);
            }
        }
        ans.add(list2);

        return ans;
    }
}
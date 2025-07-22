class Solution {
    public int missingNumber(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> collector=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                continue;
            }
            else{
                collector.add(arr[i]);
            }
        }
        int val=1;
        while (collector.contains(val)) {
            val++;
        }
        return val;
        
    }
}


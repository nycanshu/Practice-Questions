class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[10001];

        Stack<Integer> stack = new Stack<>();
        
        int n1= nums1.length;
        int n2 = nums2.length;

        //traverse from last 
        for(int i=n2-1; i>=0 ; i-- ){

            //remove the elements from stack if the stach.pop is less than curr element
            while( !stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }

            //if not empty means we got the nearnest greater as peek only
            nextGreater[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();

            //push the current as max now
            stack.push(nums2[i]);

        }

        //override nums[i] with nextGreater arrays
        for(int i=0;i<nums1.length;i++){
            nums1[i] = nextGreater[nums1[i]];
        }

        return nums1;
    }

}
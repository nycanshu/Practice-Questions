class Solution {
    public int maxSum(int arr[]) {
        // code here
         // Your code goes here
        int sum = 0;
        int maxi = arr[0];
        for(int i = 0; i < arr.length-1; i++){
            sum = arr[i] + arr[i+1];
            if(sum > maxi) maxi = sum;
        }
        return maxi;
    }
}
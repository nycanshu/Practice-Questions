class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int n = s.length();
        long sum = 0;
        long prev = 0;
        int mod = 1000000007;
        
        for(int i=0; i<n; i++){
            int num = s.charAt(i) - '0';
            prev = prev *10 + (long)(i + 1) * num;
            sum += prev;
        }
        
        return (int)sum;
    }
}
//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        // Trim leading whitespace
        s = s.trim();
        
        // Check if the string is empty after trimming
        if (s.isEmpty()) {
            return 0;
        }
        
        int index = 0;
        int sign = 1; // Default sign is positive
        int result = 0;
        int length = s.length();
        
        // Check for sign
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        
        // Convert the digits
        while (index < length) {
            char currentChar = s.charAt(index);
            if (currentChar < '0' || currentChar > '9') {
                break; // Stop if we encounter a non-digit character
            }
            
            int digit = currentChar - '0'; // Convert char to int
            
            // Check for overflow/underflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit; // Build the result
            index++;
        }
        
        return result * sign; // Apply the sign to the result
    }
}
//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution {
    int atoi(String s) {
        // Your code here
        int val = 0;
        boolean isChar = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check for negative sign at the beginning
            if (i == 0 && c == '-') {
                continue;
            }

            // Check if the character is not a digit
            if (c < '0' || c > '9') {
                isChar = true;
                break;
            }

            // Convert character to integer and update the result
            val = val * 10 + (c - '0');
        }

        // Handle the case if the string is not a valid integer
        if (isChar) {
            return -1;
        }

        // Return the value with proper sign
        return (s.charAt(0) == '-') ? -val : val;
    }
}

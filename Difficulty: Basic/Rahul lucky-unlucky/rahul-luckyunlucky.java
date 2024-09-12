//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            char a[] = new char[(int)(n)];
            long getAnswer[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = inputLine[i].charAt(0);
            }
            
            
            Solution obj = new Solution();
            long count = obj.flippedIndexes(a, n, getAnswer);
            System.out.println(count);
            
            if(count==0)
                System.out.println(-1);
            else
            {
                StringBuilder output = new StringBuilder();
                for(int i=0;i<count;i++)
                    output.append(getAnswer[i]+" ");
                System.out.println(output);
            }
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public int flippedIndexes(char a[], long n, long getAnswer[])
    {
           // Your code goes here
        int count = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 'T') {
                count++;
                getAnswer[j] = i + 1;
                j++;
                a[i] = 'H';

            // Check if flipping the next character is possible (within bounds)
            if (i + 1 < n) {
                if (a[i + 1] == 'H') {
                    a[i + 1] = 'T';
                } else {
                    a[i + 1] = 'H';
                }
            } else {
                // If flipping is not possible, break the loop
                break;
            }
        }
    }

    // Return the count of flips
    return count;
    }
    
}
    
        

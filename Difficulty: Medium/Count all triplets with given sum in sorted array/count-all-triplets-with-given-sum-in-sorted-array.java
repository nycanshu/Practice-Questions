//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public int countTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {

            int j = i + 1, k = arr.length - 1;

            while (j < k) {
                int s = arr[i] + arr[j] + arr[k];

                if (s == target) {
                    if (arr[j] == arr[k]) {
                        count += (k - j + 1) * (k - j) / 2;
                        break;
                    }
                    int left = 1, right = 1;
                    while (j + 1 < k && arr[j] == arr[j + 1]) {
                        j++;
                        left++;
                    }
                    while (k - 1 > j && arr[k] == arr[k - 1]) {
                        k--;
                        right++;
                    }
                    count += left * right;
                    j++;
                    k--;
                } else if (s < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}

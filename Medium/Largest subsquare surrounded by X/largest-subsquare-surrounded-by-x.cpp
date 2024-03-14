//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
  int largestSubsquare(int n, vector<vector<char>> mat) {
        int vertical_col[n][n]; 
        int horizontal_row[n][n]; 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                vertical_col[i][j] = 0; 
                horizontal_row[i][j] = 0; 
                if(mat[i][j] == 'X') {
                    vertical_col[i][j] = i == 0 ? 1 : vertical_col[i-1][j] + 1; 
                }
                if(mat[i][j] == 'X') {
                    horizontal_row[i][j] = j == 0 ? 1 : horizontal_row[i][j-1] + 1; 
                }
            }
        }
        int maxSquareSide = 0; 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(vertical_col[i][j] == 0 || horizontal_row[i][j] == 0) {
                    continue; 
                }
                int curr_side = min(vertical_col[i][j], horizontal_row[i][j]); 
                while(curr_side > 0) {
                    int v_pnt = i - curr_side + 1; 
                    int h_pnt = j - curr_side + 1;
                    
                    if(horizontal_row[v_pnt][j] >= curr_side && 
                    vertical_col[i][h_pnt] >= curr_side) {
                        maxSquareSide = max(maxSquareSide, curr_side);
                        break; 
                    }
                    curr_side--; 
                }
                
            }
        }
        return maxSquareSide; 
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<char>> a(n, vector<char>(n));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) cin >> a[i][j];
        }
        Solution ob;
        cout << ob.largestSubsquare(n, a) << "\n";
    }
}
// } Driver Code Ends
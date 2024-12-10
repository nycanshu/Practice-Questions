//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
public:
    vector<vector<int>> insertInterval(vector<vector<int>> &intervals, vector<int> &newInterval) {
        int n = intervals.size();
        int idx = -1;

        // Step 1: Find the insertion point for the new interval
        for (int i = 0; i < n; ++i) {
            if (intervals[i][0] < newInterval[0]) {
                idx = i;
            } else {
                break;
            }
        }

        // Step 2: Insert the new interval
        intervals.push_back(newInterval); // Append to the end temporarily
        for (int i = n - 1; i > idx; --i) { // Shift elements to make space
            swap(intervals[i], intervals[i + 1]);
        }

        // Step 3: Merge overlapping intervals
        vector<vector<int>> ans; // Result array
        vector<int> ele = {-1, -1}; // Temporary variable for merging intervals

        for (int i = 0; i <= n; ++i) {
            if (ele[0] == -1) {
                // Initialize the first interval to merge
                ele = intervals[i];
            } else {
                if (ele[1] >= intervals[i][0]) {
                    // If intervals overlap, merge them
                    ele[1] = max(ele[1], intervals[i][1]);
                } else {
                    // If no overlap, add the merged interval to the result
                    ans.push_back(ele);
                    ele = intervals[i]; // Start a new interval
                }
            }
        }

        // Step 4: Add the last merged interval
        ans.push_back(ele);

        return ans; // Return the final merged array
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        vector<vector<int>> intervals(N, vector<int>(2));
        for (int i = 0; i < N; i++) {
            cin >> intervals[i][0] >> intervals[i][1];
        }
        vector<int> newInterval(2);
        cin >> newInterval[0] >> newInterval[1];

        Solution obj;
        vector<vector<int>> ans = obj.insertInterval(intervals, newInterval);
        cout << "[";
        for (int i = 0; i < ans.size(); i++) {
            cout << "[" << ans[i][0] << ',' << ans[i][1] << ']';
            if (i != (ans.size() - 1))
                cout << ",";
        }
        cout << "]" << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends
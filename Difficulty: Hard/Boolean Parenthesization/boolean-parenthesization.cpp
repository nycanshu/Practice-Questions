//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function Template for C++
class Solution {
  public:
    vector<vector<vector<int>>>dp;
    void calculate(int s,int e,string &str){
        if(e<s) return;
        if(dp[s][e][0]!=-1) return;
        dp[s][e][0]=0; dp[s][e][1]=0;
        if(s==e) str[s]=='T' ? dp[s][e][0]=1 : dp[s][e][1]=1;
        for(int i=s;i<e;i++){
            if(str[i]=='^' || str[i]=='|' || str[i]=='&') continue;
             calculate(s,i,str); calculate(i+2,e,str);
             
            if(str[i+1]=='&'){
                 dp[s][e][0]+= dp[s][i][0]*dp[i+2][e][0];
                 dp[s][e][1]+= dp[s][i][1]*dp[i+2][e][0]+dp[s][i][0]*dp[i+2][e][1]+dp[s][i][1]*dp[i+2][e][1];
            }
            else if(str[i+1]=='|'){
                 dp[s][e][0]+= dp[s][i][1]*dp[i+2][e][0]+dp[s][i][0]*dp[i+2][e][1]+dp[s][i][0]*dp[i+2][e][0];
                 dp[s][e][1]+= dp[s][i][1]*dp[i+2][e][1];
            }
            else{
                 dp[s][e][0]+= dp[s][i][1]*dp[i+2][e][0] + dp[s][i][0]*dp[i+2][e][1];
                 dp[s][e][1]+= dp[s][i][1]*dp[i+2][e][1] + dp[s][i][0]*dp[i+2][e][0];
            }
        }
    }
    
    int countWays(string &str) {
        int n=str.size();
        dp.assign(n,vector<vector<int>>(n,vector<int>(2,-1)));
        calculate(0,n-1,str);
        return dp[0][n-1][0];
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        int ans = ob.countWays(s);
        cout << ans << endl;
        cout << "~" << endl;
    }
}
// } Driver Code Ends
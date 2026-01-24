class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m][n];
        //base cases 
        dp[0][0]=0; // no movement
        for(int i=0;i<m;i++){
            dp[i][0]=1;//right movement
        }
        for(int j=0;j<n;j++){
            dp[0][j]=1;//down movement
        }
        //fill the table
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j] + dp[i][j-1]; // from top or from left 
            }
        }
        return dp[m-1][n-1];
    }
}
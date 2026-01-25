class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        // base case // first row
        for(int j=0;j<m;j++){
            dp[0][j]=matrix[0][j];
        }
        // fill the dp
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=dp[i-1][j];
                int left_up_diag=(j>0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int right_up_diag=(j<m-1) ? dp[i-1][j+1] : Integer.MAX_VALUE;

                dp[i][j]=matrix[i][j] + Math.min(up,Math.min(left_up_diag,right_up_diag));
            }
        }
        // answer = min value in last row
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            ans=Math.min(ans,dp[n-1][j]);
        }
        return ans;
    }
}
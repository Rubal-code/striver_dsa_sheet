class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int [][]dp=new int[n][m];
        //base cases
        // start cell
        if(matrix[0][0]==1) return 0;
        dp[0][0]=1;
        // first column
        for(int i=1;i<n;i++){
            if(matrix[i][0]==1){
                dp[i][0]= 0;
            }
            else{
            dp[i][0]=dp[i-1][0];
            }
        }
        //first row
        for(int j=1;j<m;j++){
            if(matrix[0][j]==1){
                dp[0][j]=0;
            }
            else{
            dp[0][j]=dp[0][j-1];
            }
        }
        // fill the dp
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==1){
                    dp[i][j]=0;
                }
                else{
                dp[i][j]=dp[i-1][j] + dp[i][j-1];
            }
            }
        }
        return dp[n-1][m-1];
    }
}
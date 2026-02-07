class Solution {
    public int distinctSubsequences(String s, String t) {
        int n=s.length();
        int m=t.length();
        int MOD = 1000000007;
        int [][]dp=new int[n+1][m+1];
        // Base case: empty target
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j]) % MOD;  // take and then skip
                }
                else{
                    dp[i][j]=dp[i-1][j];//only skip
                }
            }
        }
        return dp[n][m];
    }
}
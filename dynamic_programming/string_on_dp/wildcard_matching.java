class Solution {
    public boolean wildCard(String str, String pat) {
       int n=str.length();
       int m=pat.length();
       // dp[i][j] = true if str[0..i-1] matches pat[0..j-1]
       boolean[][]dp=new boolean[n+1][m+1];
       // empty str and empty pat
       dp[0][0]=true;
       // Empty pattern cannot match non-empty string
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }
        // Empty string & pattern with '*'
        for (int j = 1; j <= m; j++) {
            if (pat.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }

        // fill the dp table
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(pat.charAt(j-1)==str.charAt(i-1) || pat.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(pat.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1] || dp[i-1][j];//"*" matches empty string
                    // "* matches one or more characters"
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];

    }

}

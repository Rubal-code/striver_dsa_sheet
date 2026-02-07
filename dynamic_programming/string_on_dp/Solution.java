public class Solution {
    public int editDistance(String start, String target) {
        int n=start.length();
        int m=target.length();
        if(n==0 && m==0){
            return 0;
        }
        int dp[][]=new int[n+1][m+1];
        // base cases
        for(int i=0;i<=n;i++){
            dp[i][0]=i; //del i chars
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;//insert j chars
        }

        // fill the dp
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(start.charAt(i-1)==target.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];//if match then no operation need
                }
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));//del , insert , replace
                }
            }
        }
        return dp[n][m];
    }
}


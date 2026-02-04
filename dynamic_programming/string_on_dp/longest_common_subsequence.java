class Solution {
    public int lcs( String str1, String str2) {
     int n=str1.length();
     int m=str2.length();

        // dp[i][j] = LCS length of str1[0..i-1] and str2[0..j-1]
     int [][]dp=new int[n+1][m+1];//one extra row and col for empty str
     for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
            }
            else{
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
     }
     return dp[n][m];
    }
}


class Solution {
    public int longestCommonSubstr(String str1, String str2) {
     int n=str1.length();
     int m=str2.length();
     int [][]dp=new int[n+1][m+1];
     int maxlen=0;
     for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
                maxlen=Math.max(dp[i][j],maxlen);
            }
            else{
                dp[i][j]=0;// reset on mismatch
            }
        }
     }
     return maxlen;
    }
}
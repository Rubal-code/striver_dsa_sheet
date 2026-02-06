class Solution {
    public int minInsertion(String s) {
        int n=s.length();
        if(n==0 || n==1){
            return 0;
        }
        String rev=new StringBuilder(s).reverse().toString();
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int lps=dp[n][n];
        return n-lps;
    }
}
// here the concept is the total length of string - longest palindrome subsequence

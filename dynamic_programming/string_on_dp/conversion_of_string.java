class Solution {
    public int minOperations(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        if(n==0 && m==0){
            return 0;
        }
        int [][]dp=new int[n+1][m+1];
        //base cases
        for(int i=0;i<=n;i++){
            dp[i][0]=i;// delete i characters as take as example you have to make "" from "cat" 3 operations of delete
        }
        for (int j=0;j<=m;j++){
            dp[0][j]=j;// insert j chars
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];//no operations
                }
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j] , dp[i][j-1]);//del and insert 
                }
            }
        }
        return dp[n][m];
    }
}


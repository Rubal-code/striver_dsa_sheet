class Solution{
    public int RodCutting(int price[], int n) {
        
        int []dp=new int[n+1];
        dp[0]=0;
        for(int i=0;i<price.length;i++){
            for(int len=i+1;len<=n;len++){
                dp[len]=Math.max(dp[len],price[i] + dp[len -(i+1)]);
            }
        }
        return dp[n];
    }
}
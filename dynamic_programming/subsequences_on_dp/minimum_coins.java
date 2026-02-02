class Solution {
    public int MinimumCoins(int[] coins, int amount) {
        int n=coins.length;
        int[]dp=new int[amount+1];
        // intialize with large values
        for(int i=1;i<=amount;i++){
            dp[i]=amount+1;// acts like infinity
        }
        dp[0]=0;//base case
        for(int coin:coins){
            for(int s=coin;s<=amount;s++){
                dp[s]=Math.min(dp[s],dp[s-coin]+1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}


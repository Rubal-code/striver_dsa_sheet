class Solution {
    public int count(int[] coins, int N, int amount) {
      int dp[]=new int[amount+1];
      dp[0]=1;// base case
      for(int coin:coins){
        for(int s=coin;s<=amount;s++){// forward loop (unbounded knapsack as we can reuse one coin)
            dp[s]+=dp[s-coin];    //If dp uses += → dp[0] = 1
                                  //If dp uses min/max → dp[0] = 0
        }
      }
      return dp[amount];
    }
}

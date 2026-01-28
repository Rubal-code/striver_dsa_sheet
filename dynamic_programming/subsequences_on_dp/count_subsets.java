class Solution {
    public int perfectSum(int[] arr, int K) {
        int n=arr.length;
        
        
        int[] dp=new int[k+1];
        dp[0]=1;//base case
        //fill the dp
        for(int num:arr){
            for(int s=k;s>=num;s--){
                dp[s]=dp[s] || dp[s-num];
            }
        }
        return dp[k];

    }
}


class Solution {
    public boolean equalPartition(int n, int[] arr) {
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        // If sum is odd, cannot partition
        if (sum % 2 != 0) return false;

        int target=sum/2;
        boolean[] dp=new boolean[target+1];

        dp[0]=true;//base case
        for(int num:arr){
            for(int s=target;s>=num;s--){
                dp[s]=dp[s] || dp[s-num];
            }
        }
        return dp[target];
    }
}

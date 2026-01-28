//Partition a set into two subsets with minimum absolute sum difference
class Solution {
    public int minDifference(int[] arr, int n) {
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        boolean[] dp=new boolean[sum+1]; // this size becuz eg[1,2,3] the possible sum value exists[0,1,2,3,4,5,6]
        dp[0]=true;//base case
        for(int num:arr){
            for(int s=sum;s>=num;s--){
                dp[s]=dp[s] || dp[s-num];
            }
        }
        int min_diff=Integer.MAX_VALUE;
        for(int s=0;s<=sum/2;s++){
            if(dp[s]){
                min_diff=Math.min(min_diff,sum-2*s);
            }
        }
        return min_diff;
    }
}

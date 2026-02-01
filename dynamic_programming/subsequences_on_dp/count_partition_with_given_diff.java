class Solution {
 public int countPartitions(int n, int diff, int[] arr) {
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        if((sum+diff) % 2 !=0){
            return 0; // no partitions
        }
        int target=(sum+diff)/2;//The target is the sum of one of the subsets (S1) that we want to find, because the problem asks:
        int dp[]=new int[target+1];
        dp[0]=1;//base case // base case: sum 0 can be formed in 1 way (empty subset)
        for(int num:arr){
            for(int s=target;s>=num;s--){
                dp[s]+= dp[s-num];
            }
        }
        return dp[target];
    }
}

class Solution {
    public int LIS(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int max=1; // every element is the longest subsequence of itself
        int []dp=new int[n];
        Arrays.fill(dp,1);
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}


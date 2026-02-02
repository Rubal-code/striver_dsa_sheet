class Solution {
    public int targetSum(int target, int[] nums) {
    int total_sum=0;
    
     
    for(int num:nums){
        total_sum+=num;
    }
    if(total_sum < Math.abs(target) || (target + total_sum) %2 !=0){
        return 0;
    }
    int s1=(target+total_sum)/2;
    int []dp=new int [s1+1];
    dp[0]=1;//base case

    for(int num:nums){
        for(int s=s1;s>=num;s--){
            dp[s]+=dp[s-num];
        }
    }
    return dp[s1];
    }
}


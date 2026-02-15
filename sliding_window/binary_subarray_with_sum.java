class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
         return atmost(nums,goal) - atmost(nums,goal-1);

    }
    private int atmost(int []nums,int goal){
        if(goal<0) return 0;  //imp edge case
        int i=0;
        int sum=0;
        int count=0;//count num of Subarrays

        for(int j=0;j<nums.length;j++){
            sum+=nums[j];

            while(sum > goal){
                sum-=nums[i];
                i++;
            }
            count+=(j-i+1);
        }
        return count;
    }
}
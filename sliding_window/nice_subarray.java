class Solution {
    public int numberOfOddSubarrays(int[] nums, int k) {
        //your code goes here
        return atmost(nums,k) - atmost(nums,k-1);
    }
    private int atmost(int []nums,int k){

        if(k<0) return 0;//edge case
        int i=0;
        int count=0;
        int odd_number=0;

        for(int j=0;j<nums.length;j++){
            if(nums[j]%2!=0){
                odd_number++;
            }
            while(odd_number > k){
                if(nums[i]%2 != 0){
                odd_number--;
                }
                i++;
            }
            count+=(j-i+1);
        }
        return count;
    }
}
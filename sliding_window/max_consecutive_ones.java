class Solution {
    public int longestOnes(int[] nums, int k) {
        //your code goes here
        int i=0;
        int j=0;
        int ans=0;
        int zero_count=0; // count zeros in the window
        int n=nums.length;

        while(j<n){
            // if the current element is zero then increase count
            if(nums[j]==0){
                zero_count++;
            }
            // if zero exceeds the window then shrink the window
            while(zero_count > k){
                if(nums[i]==0){
                    zero_count--;
                }
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
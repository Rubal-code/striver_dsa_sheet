class Solution {
    public int frogJump(int[] heights) {
        int n = heights.length;
        
        // base case
        int prev2=0 ; // dp[0]
        int prev1=Math.abs(heights[1] - heights[0]);//dp[1]

        for(int i=2;i<n;i++){
            int jump_one=prev1 + Math.abs(heights[i] - heights[i-1]);
            int jump_two=prev2 + Math.abs(heights[i] - heights[i-2]);
            int curr=Math.min(jump_one,jump_two);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
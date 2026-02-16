class Solution {
    public int maxScore(int[] cardScore, int k) {
        //your code goes here
        int n=cardScore.length;
        //step 1 total sum
        int totalsum=0;
        for(int num:cardScore){
            totalsum+=num;
        }
        //if we take all the cardS
        if(n==k) return totalsum;
        //step 2 window size we need to remove
        int windowSize=n-k;
        int currentSum=0;
        int minSum=Integer.MAX_VALUE;

        int i=0;
        // Step 3: Sliding window to find minimum sum subarray of size (n-k)
        for(int j=0;j<n;j++){
            currentSum+=cardScore[j];//expand window
            //when the window size reached
            if(j-i+1 == windowSize){
                minSum=Math.min(minSum,currentSum);
                // update minimum sum
                currentSum-=cardScore[i];
                //shrink the window
                i++;
            }
        }
        // Step 4: Maximum score = totalSum - minimum removed sum
        return totalsum - minSum;
    }
}
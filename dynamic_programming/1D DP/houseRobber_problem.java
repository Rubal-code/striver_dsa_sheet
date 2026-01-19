class houseRobber_problem {
    public int houseRobber(int[] money) {
        int n=money.length;
        if (n==0) return 0;
        if (n==1) return money[0];
        return Math.max(robe(0,n-2,money),robe(1,n-1,money));// exclude first house one time and last house one time because they are interconnected
    }
    private int robe(int start,int end,int[]nums){
        int prev2=0;
        int prev1=0;
        for(int i=start;i<=end;i++){
            int curr=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
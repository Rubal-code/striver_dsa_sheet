class Solution {
    public int stockBuySell(int[] arr, int n, int fee) {
       if(n==0) return 0;

       int buy=-arr[0];
       int sell=0;
       for(int i=1;i<n;i++){
        buy=Math.max(buy,sell-arr[i]);
        sell=Math.max(sell,buy+arr[i]-fee);
       }
       return sell;
    }
}

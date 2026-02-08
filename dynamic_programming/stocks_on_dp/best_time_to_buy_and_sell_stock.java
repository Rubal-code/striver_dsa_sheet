class Solution {
    public int stockBuySell(int[] arr, int n) {
       if(n==0) return 0;
       int min_price=arr[0];
       int max_profit=0;

       for(int i=1;i<n;i++){
        // update max profit is selling today gives better profit
        max_profit=Math.max(max_profit , arr[i]-min_price);
        // update minimum price so far
        min_price=Math.min(arr[i] , min_price);
       }
       return max_profit;
    }
}
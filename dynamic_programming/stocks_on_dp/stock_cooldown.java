class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) return 0;


        int buy=-prices[0];
        int sell=0;
        int cooldown=0;

        for (int i = 1; i < n; i++) {
            int prevbuy=buy;
            int prevsell=sell;
            int prevcooldown=cooldown;

            buy=Math.max(prevbuy,prevcooldown-prices[i]);
            sell=prevbuy + prices[i];
            cooldown=Math.max(prevcooldown,prevsell);

            
        }
        return Math.max(sell,cooldown);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int minprice = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            max = Math.max(max, prices[i] - minprice);
            minprice = Math.min(prices[i], minprice);
        }
        return max;
    }
}
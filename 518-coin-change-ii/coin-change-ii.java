class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int t = 0; t <= amount; t++){
            dp[0][t] = (t % coins[0] == 0) ? 1 : 0;
        }
        for(int idx = 1; idx < n; idx++){
            for(int t = 0; t <= amount; t++){
                int notake = dp[idx - 1][t];
                int take = 0;
                if(coins[idx] <= t){
                    take = dp[idx][t - coins[idx]];
                }
                dp[idx][t] = take + notake;
            }
        }
        return dp[n - 1][amount];
    }
}
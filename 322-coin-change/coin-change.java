class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int T = 0; T <= amount; T++){
            if(T % coins[0] == 0){
                dp[0][T] = T / coins[0];
            }else{
                dp[0][T] = Integer.MAX_VALUE;
            }
        }
        for(int idx = 1; idx < n; idx++){
            for(int t = 0; t <= amount; t++){
                int notake = 0 + dp[idx - 1][t];
                int take = Integer.MAX_VALUE;
                if(coins[idx] <= t){
                    int prev = dp[idx][t - coins[idx]];
                    if (prev != Integer.MAX_VALUE)
                        take = 1 + prev;
                }
                dp[idx][t] = Math.min(take, notake);
            }
        }
        int ans = dp[n - 1][amount];                      
        return ans == Integer.MAX_VALUE ? -1 : ans; 
    }
}
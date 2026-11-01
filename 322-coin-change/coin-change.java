
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        int ans = solve(n - 1, coins, amount, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int solve(int idx, int[] coins, int target, int[][] dp) {

        if (target == 0) {
            return 0;
        }

        if(dp[idx][target] != -1){
            return dp[idx][target];
        }
        if (idx == 0) {
            if (target % coins[0] == 0) {
                return target / coins[0];
            }
            return Integer.MAX_VALUE;
        }

        int notake = solve(idx - 1, coins, target, dp);

        int take = Integer.MAX_VALUE;

        if (coins[idx] <= target) {
            int result = solve(idx, coins, target - coins[idx], dp);

            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }

        return dp[idx][target] = Math.min(take, notake);
    }
}

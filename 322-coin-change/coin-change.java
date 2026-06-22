class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Base case: using only coins[0]
        for (int T = 0; T <= amount; T++) {
            if (T % coins[0] == 0) {
                dp[0][T] = T / coins[0];
            } else {
                dp[0][T] = Integer.MAX_VALUE; // unreachable
            }
        }

        for (int idx = 1; idx < n; idx++) {
            for (int target = 0; target <= amount; target++) { // fix 1: <= amount
                int notake = dp[idx - 1][target];
                int take = Integer.MAX_VALUE;              // fix 2: MAX_VALUE

                if (coins[idx] <= target) {
                    int prev = dp[idx][target - coins[idx]];
                    if (prev != Integer.MAX_VALUE) {       // fix 4: overflow guard
                        take = 1 + prev;
                    }
                }
                dp[idx][target] = Math.min(take, notake);
            }
        }

        int ans = dp[n - 1][amount];                      // fix 3: n-1
        return ans == Integer.MAX_VALUE ? -1 : ans;       // fix 5: return -1
    }
}
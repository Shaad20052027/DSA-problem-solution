class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
    int solve(int i, int[] dp){
        if(i == 0){
            return 1;
        }
        if(i < 0) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        return dp[i] = solve(i - 1, dp) + solve(i - 2, dp);
    }
}
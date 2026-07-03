class Solution {
    private int robin(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int take   = nums[i] + dp[i - 2];
            int notake = dp[i - 1];
            dp[i] = Math.max(take, notake);
        }
        return dp[n - 1];
    }  

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] temp1 = Arrays.copyOfRange(nums, 0, n - 1);
        int[] temp2 = Arrays.copyOfRange(nums, 1, n);

        return Math.max(robin(temp1), robin(temp2));
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 != 0){
            return false;
        }
        int n = nums.length;
        int target = sum/2;
        boolean[][] dp = new boolean[n][target + 1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i = 1; i < n; i++){
            for(int t = 1; t <= target; t++){
                boolean notake = dp[i - 1][t];
                boolean take = false;
                if (t >= nums[i]) {
                    take = dp[i - 1][t - nums[i]];
                }
                dp[i][t] = take || notake;
            }
        }
        return dp[n - 1][target];
    }
}
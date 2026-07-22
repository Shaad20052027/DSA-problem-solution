class Solution {
    public boolean canPartition(int[] nums) {
        int sum1 = Arrays.stream(nums).sum();
        if(sum1 % 2 != 0){
            return false;
        }
        int sum = sum1 / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];
        if(sum >= nums[0]){
            dp[0][nums[0]] = true;
        }
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i < n; i++){
            for(int target = 1; target <= sum; target++){
                boolean notake = dp[i - 1][target];
                boolean take = false;
                if(nums[i] <= target){
                    take = dp[i - 1][target - nums[i]];
                }
                dp[i][target] = take || notake;
            }
        }
        return dp[n - 1][sum];
    }
}
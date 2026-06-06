class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int leftsum = 0;
        int rightsum = 0;
        int totalsum = 0;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            totalsum += nums[i];
        }
        for(int i = 0; i < n; i++){
            rightsum = totalsum - leftsum - nums[i];
            ans[i] = Math.abs(leftsum - rightsum);
            leftsum = leftsum + nums[i];
        }
        return ans;
    }
}
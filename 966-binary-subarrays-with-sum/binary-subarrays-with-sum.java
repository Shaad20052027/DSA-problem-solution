class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums, goal) - atmost(nums,goal - 1);
    }
    private int atmost(int[] nums, int k){
        if(k < 0){
            return 0;
        }
        int left = 0, right = 0, count = 0,sum = 0;
        while(right < nums.length){
            sum = sum + nums[right];
            while(sum > k){
                sum = sum - nums[left];
                left++;
            }
            count = count + (right - left)+1;
            right++;
        }
        return count;
    }
}
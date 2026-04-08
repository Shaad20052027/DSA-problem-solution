class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int mini = -1, maxi = -1, valid = -1;
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < minK || nums[i] > maxK){
                valid = i;
            }
            if(nums[i] == minK)
            mini = i;
            if(nums[i] == maxK)
            maxi = i;
            int start = Math.max(0,Math.min(maxi,mini) - valid);
            count += start;
        }
        return count;
    }
}
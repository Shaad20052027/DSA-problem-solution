class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;
        int ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= nums[start]){
                ans = Math.min(nums[start], ans);
                start = mid + 1;
            }else{
                ans = Math.min(nums[mid], ans);
                end = mid - 1;
            }
        }
        return ans;
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] ans = {-1, -1};
        int n = nums.length;
        ans[0] = search(0, n - 1, true, nums, target);
        ans[1] = search(0, n - 1, false, nums, target);
        return ans;
    }
    private int search(int start, int end, boolean firstindex, int[] nums, int target){
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < nums[mid]){
                end = mid - 1;
            }else if(target > nums[mid]){
                start = mid + 1;
            }else{
                ans = mid;
                if(firstindex)
                {
                    end=mid-1;

                }
                else{
                   start=mid+1;
                }
            }
        }
        return ans;
    }
}
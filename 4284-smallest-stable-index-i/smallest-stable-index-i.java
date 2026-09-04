class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n =  nums.length;
        int[] psum = new int[n];
        int[] ssum = new int[n];
        psum[0] = nums[0];
        for(int i = 1; i < n; i++){
            psum[i] = Math.max(psum[i - 1], nums[i]);
        }
        ssum[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            ssum[i] = Math.min(ssum[i + 1], nums[i]);
        }
        for(int i = 0; i < n; i++){
            if(psum[i] - ssum[i] <= k){
                return i;
            }
        }
        return -1;
    }
}
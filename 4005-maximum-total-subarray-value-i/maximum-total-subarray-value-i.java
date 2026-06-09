class Solution {
    public long maxTotalValue(int[] nums, int k) {
        if(nums.length == 1){
            return 0;
        }
        long gmax = Integer.MIN_VALUE;
        long gmin = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < gmin){
                gmin = nums[i];
            }if(nums[i] > gmax){
                gmax = nums[i];
            }
        }
        return k * (gmax - gmin);
    }
}
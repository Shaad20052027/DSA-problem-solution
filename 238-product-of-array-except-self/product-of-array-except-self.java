class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] =res[i-1] * nums[i-1];
        }
        int rightprd = 1;
        for(int r = nums.length - 1; r >= 0; r--){
            res[r] = res[r] * rightprd;
            rightprd *= nums[r];
        }
        return res;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j =i+1; j < n; j++){
                sum = nums[i] + nums[j];
                if(sum == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }
}
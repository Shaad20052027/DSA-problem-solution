class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, j = 0;
        double sum = 0.0;
        double max = Double.NEGATIVE_INFINITY;
        double avg = 0.0;
        while(j < nums.length){
            sum = sum + nums[j];
            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                avg = sum/k;
                max = Math.max(max,avg);
                sum = sum - nums[i];
                i++;
                j++;
            }
        }
        return max;
    }
}
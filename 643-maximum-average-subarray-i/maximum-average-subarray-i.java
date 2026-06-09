class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, j = 0;
        double avg = 0;
        double sum = 0.0;
        double max = Double.NEGATIVE_INFINITY;
        while(j < nums.length){
            sum += nums[j];
            if(j - i + 1 < k){
                j++;
            }
            else{
                avg = sum / k;
                max = Math.max(avg,max);
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return max;
    }
}
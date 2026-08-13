class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        while(low <= high){
            int mid = low + (high - low) / 2;
            int sum = div(nums, mid);
            if(sum <= threshold){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    private int div(int[] nums, int mid){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += (int)Math.ceil((double)nums[i]/mid);
        }
        return sum;
    }
}
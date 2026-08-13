class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        if((long)m * k > bloomDay.length){
            return - 1;
        }
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isday(bloomDay, mid, k, m) == true){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;

    }
    private boolean isday(int[] nums, int mid, int k, int m){
        int cnt = 0, ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= mid){
                cnt++;
            }else {
                ans += cnt / k;
                cnt = 0;
            }
        }
        ans += cnt / k;
        return (ans >= m) ? true : false;
    }
}
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = Arrays.stream(weights).sum();
        int max = Arrays.stream(weights).max().getAsInt();
        int low = max, high = sum;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int noofdays = findays(weights, mid);
            if(noofdays <= days){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    int findays(int[] weights, int cap){
        int day = 1, load = 0;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] + load > cap){
                day += 1;
                load = weights[i];
            }else {
                load += weights[i];
            }
        }
        return day;
    }
}
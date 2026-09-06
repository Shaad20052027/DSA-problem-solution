class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalKharch = Arrays.stream(cost).sum();
        int totalKamai = Arrays.stream(gas).sum();
        if(totalKamai < totalKharch){
            return -1;
        }
        int n = cost.length;
        int result = 0;
        int total = 0;
        for(int i = 0; i < n; i++){
            total = total + gas[i] - cost[i];
            if(total < 0){
                total = 0;
                result = i + 1;
            }
        }
        return result;
    }

}
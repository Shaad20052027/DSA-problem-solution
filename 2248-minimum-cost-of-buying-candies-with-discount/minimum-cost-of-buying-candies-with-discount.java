class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int i = n - 1;
        int mincost = 0;
        while(i >= 0){
            if(i >= 2){
                mincost += cost[i] + cost[i - 1];
                i = i - 3;
            }else if(i == 1){
                mincost += cost[i] + cost[i - 1];
                i = i - 2;
            }else if(i == 0){
                mincost += cost[i];
                i = i - 1; 
            }
        }
        return mincost;
    }
}
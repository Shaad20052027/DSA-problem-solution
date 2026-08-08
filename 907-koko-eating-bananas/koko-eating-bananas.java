class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        int r = max;

        while(l < r){
            int mid = l + (r - l) / 2;
            if(caneatall(piles, h, mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean caneatall(int[] piles, int h, int mid){
        int actualhour = 0;
        for(int x : piles){
            actualhour += x/mid;
            if(x % mid!= 0){
                actualhour++;
            }
        }
        return actualhour <= h;
    }
}
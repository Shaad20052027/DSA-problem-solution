class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int left = 0,right = k -1;
        for(int i = 0; i <= right; i++){
            sum += cardPoints[i];
        }
        int max = sum;
        int lastPart = cardPoints.length - 1;
        for(int i = right; i >= 0; i--){
            sum = sum - cardPoints[i];
            sum = sum + cardPoints[lastPart];
            max = Math.max(max,sum);
            lastPart--;
        }
        return max;  
    }
}
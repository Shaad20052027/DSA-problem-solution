class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int n = height.length;
        int right = n - 1;
        int max = Integer.MIN_VALUE;
        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
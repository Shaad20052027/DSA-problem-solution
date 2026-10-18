class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int max = 0;
        while(left < right){
            int width = right - left;
            int heights = Math.min(height[left], height[right]);
            max = Math.max(max, width * heights);
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
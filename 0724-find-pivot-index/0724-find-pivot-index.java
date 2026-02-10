public class Solution {
    public int pivotIndex(int[] nums) {
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Initialize left sum as 0
        int leftSum = 0;
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the right sum by subtracting the left sum and the current element from total sum
            int rightSum = totalSum - leftSum - nums[i];
            
            // If left sum equals right sum, return the pivot index
            if (leftSum == rightSum) {
                return i;
            }
            
            // Update the left sum for the next iteration
            leftSum += nums[i];
        }
        
        // If no pivot index found, return -1
        return -1;
    }
}

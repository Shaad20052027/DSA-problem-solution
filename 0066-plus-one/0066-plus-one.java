public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse the digits array from the last digit to the first
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, just increment it and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // Otherwise, set the current digit to 0 and continue to the next more significant digit
            digits[i] = 0;
        }
        
        // If we finish the loop, it means we have a carry-over, e.g., 999 + 1 = 1000
        // So we need a new array of length n + 1 with the first element set to 1
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}

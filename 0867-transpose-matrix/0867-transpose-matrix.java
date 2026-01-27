public class Solution {
    public int[][] transpose(int[][] A) {
        // Initialize the result matrix with swapped dimensions
        int m = A.length;    // number of rows in A
        int n = A[0].length; // number of columns in A
        
        // Create a new matrix to store the transposed result
        int[][] result = new int[n][m];
        
        // Perform the transpose by swapping rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = A[i][j];  // Swap A[i][j] to result[j][i]
            }
        }
        
        return result;
    }
}

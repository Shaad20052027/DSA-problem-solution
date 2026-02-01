public class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Check if reshape is possible
        if (rows * cols != r * c) {
            return mat;
        }

        int[][] reshaped = new int[r][c];
        int[] flat = new int[rows * cols];

        // Flatten the original matrix into a 1D array
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flat[index++] = mat[i][j];
            }
        }

        // Fill the reshaped matrix with the flattened data
        index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshaped[i][j] = flat[index++];
            }
        }

        return reshaped;
    }
}

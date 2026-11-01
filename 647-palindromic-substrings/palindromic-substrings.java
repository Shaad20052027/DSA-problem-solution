class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){

                if(solve(i, j, s, dp)){
                    count++;
                }
            }
        }

        return count;
    }

    boolean solve(int i, int j, String s, int[][] dp){

        if(i >= j){
            return true;
        }

        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }

        boolean ans = false;

        if(s.charAt(i) == s.charAt(j)){
            ans = solve(i + 1, j - 1, s, dp);
        }

        dp[i][j] = ans ? 1 : 0;

        return ans;
    }
}
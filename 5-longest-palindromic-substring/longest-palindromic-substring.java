
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int start = 0;

        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){

                if(solve(i, j, s, dp)){
                    int len = j - i + 1;

                    if(len > maxLen){
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    boolean solve(int i, int j, String s, int[][] dp){

        if(i >= j){
            return true;
        }

        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }

        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = solve(i + 1, j - 1, s, dp) ? 1 : 0;
        }
        else{
            dp[i][j] = 0;
        }

        return dp[i][j] == 1;
    }
}

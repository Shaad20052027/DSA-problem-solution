class Solution {
    public String longestPalindrome(String s) {
        int maxlen = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            int odd = expands(s, i - 1, i + 1);
            int even = expands(s, i, i + 1);
            int best = Math.max(odd,even);
            if(best > maxlen){
                maxlen = best;
                start = i - (best - 1)/2;
            }
        }
        return s.substring(start,start + maxlen);
    }
    int expands(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left = left - 1;
            right = right + 1;
        } 
        return right - left - 1;
    }
}
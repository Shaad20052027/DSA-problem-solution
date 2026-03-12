class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, right = 0, maxlen = 0,maxcount = 0;
        int n = s.length();
        while(right < n){
            freq[s.charAt(right) - 'A']++;
            maxcount = Math.max(maxcount,freq[s.charAt(right) - 'A']);
            while((right - left + 1) - maxcount > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxlen = Math.max(maxlen,right - left + 1);
            right++;
        }
        return maxlen;    
    }
}
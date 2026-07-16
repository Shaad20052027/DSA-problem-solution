class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, maxcount = 0, maxlen = 0;
        int[] freq = new int[26];
        while(j < s.length()){
            freq[s.charAt(j) - 'A']++;
            maxcount = Math.max(maxcount, freq[s.charAt(j) - 'A']);
            while((j - i + 1) - maxcount > k){
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            maxlen = Math.max(maxlen, j - i + 1);
            j++;
        }
        return maxlen;
    }    
}
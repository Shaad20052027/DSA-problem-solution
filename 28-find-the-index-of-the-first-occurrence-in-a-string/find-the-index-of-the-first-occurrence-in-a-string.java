class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int k = needle.length();

        for(int i = 0; i <= n - k; i++){
            int j = 0;

            while(j < k && haystack.charAt(i + j) == needle.charAt(j)){
                j++;
            }

            if(j == k){
                return i;
            }
        }

        return -1;
    }
}
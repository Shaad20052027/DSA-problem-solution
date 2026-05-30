class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        int n = s1.length();
        String str = "";

        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                str += ch;
            }
        }
        int start = 0, end = str.length() - 1;
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        String ans = "";
        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9'){
                ans += ch;
            }
        }
        int left = 0, right = ans.length() - 1;
        while(left <= right){
            if(ans.charAt(left) == ans.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
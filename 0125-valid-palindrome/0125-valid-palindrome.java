class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        String str = "",palstr="";
        char ch =' ';
        for(int i = 0; i < s1.length(); i++){
            ch =s1.charAt(i);
            if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9'){
                str += ch;
            }
        }
        String temp = str;
        for(int i = temp.length()-1; i >=0; i--){
            ch = temp.charAt(i);
            palstr += ch;
        }
        if(palstr.equals(str)){
            return true;
        }
        return false;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> list = new HashSet<>();
        int i = 0, j = 0;
        int max = 0;
        int n = s.length();
        while(j < n){
            char ch = s.charAt(j);
            if(!list.contains(ch)){
                list.add(ch);
                max = Math.max(max, j - i + 1);
                j++;
            }else{
                list.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
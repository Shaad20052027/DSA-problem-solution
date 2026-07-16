class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        int n = s.length();
        HashSet<Character> list = new HashSet<>();
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
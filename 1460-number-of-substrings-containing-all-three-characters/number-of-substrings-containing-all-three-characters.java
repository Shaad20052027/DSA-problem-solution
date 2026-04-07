class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0;
        String s1 = "abc";
        int ans = 0;
        for(int x = 0; x < s1.length(); x++){
            char ch = s1.charAt(x);
            map.put(ch,0);
        }
        while(j < n){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
            }
            while(map.get('a') > 0 && map.get('b') > 0 && map.get('c') > 0){
                ans += n - j;
                char left = s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left) - 1);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
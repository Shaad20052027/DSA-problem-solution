class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int i =0, j = 0;
        int k = p.length();
        for(int x = 0; x < k; x++){
            char ch = p.charAt(x);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        int count = map.size();
        while(j < s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) - 1);
                if(map.get(ch) == 0){
                    count--;
                }
            }

            if(j - i + 1 < k){
                j++;
            }
            else if( j - i + 1 == k){
                if(count == 0){
                    ans.add(i);
                }
                char leftchar = s.charAt(i);
                if(map.containsKey(leftchar)){
                    if(map.get(leftchar) == 0){
                        count++;
                    }
                    map.put(leftchar,map.get(leftchar) + 1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
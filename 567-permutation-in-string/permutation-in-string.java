class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0;
        boolean ans = false;
        for(int x = 0; x < k; x++){
            char ch = s1.charAt(x);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        int count = map.size();
        while(j < s2.length()){
            char ch = s2.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) - 1);
                if(map.get(ch) == 0){
                    count--;
                }
            }

            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                if(count == 0){
                    ans = true;
                }
                char left = s2.charAt(i);
                if(map.containsKey(left)){
                    if(map.get(left) == 0){
                        count++;
                    }
                    map.put(left,map.get(left) + 1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}    
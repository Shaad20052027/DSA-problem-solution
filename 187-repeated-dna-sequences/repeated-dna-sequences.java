class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();

        int i = 0, j = 0;
        String ans = "";

        String s1 ="ACGT";
        for(int x = 0; x < s1.length(); x++){
            char ch = s1.charAt(x);
            map.put(ch,0);
        }

        while(j < s.length()){
            char ch = s.charAt(j);

            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
                ans += ch;
            }

            // maintain window size = 10
            if(ans.length() < 10){
                j++;
            }
            else if(ans.length() == 10){

                // store substring
                map2.put(ans, map2.getOrDefault(ans, 0) + 1);

                j++;
            }
            else if(ans.length() > 10){
                char left = s.charAt(i);

                map.put(left, map.get(left) - 1);

                // shrink window
                ans = ans.substring(1);
                i++;

                // after shrinking, check again
                if(ans.length() == 10){
                    map2.put(ans, map2.getOrDefault(ans, 0) + 1);
                }

                j++;
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for(String key : map2.keySet()){
            if(map2.get(key) > 1){
                list.add(key);
            }
        }

        return list;
    }
}
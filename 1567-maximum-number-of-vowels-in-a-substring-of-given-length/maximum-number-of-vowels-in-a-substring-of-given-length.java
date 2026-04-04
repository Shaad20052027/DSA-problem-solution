class Solution {
    public int maxVowels(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0;
        String p = "aeiou";
        for(char ch : p.toCharArray()){
            map.put(ch,0);
        }
        int max = Integer.MIN_VALUE;
        while(j < s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
            }
            if(j - i + 1 < k){
                j++;
            }else if(j - i + 1 == k){
                int sum = 0;
                for(int val : map.values()){
                    sum += val;
                }
                max = Math.max(sum,max);
                char left = s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left) - 1);
                }
                i++;
                j++;
            }
        }
        return max;
    }
}
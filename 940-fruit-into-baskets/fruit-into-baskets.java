class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int curLen = 0, maxlen = 0;
        int i = 0, j = 0;
        int n = fruits.length;
        while(j < n){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            if(map.size() > 2){
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            curLen = j - i + 1;
            maxlen = Math.max(curLen, maxlen);
            j++;
        }
        return maxlen;
    }
}
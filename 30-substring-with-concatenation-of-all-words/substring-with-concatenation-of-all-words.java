class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> tmap = new HashMap<>();
        for (String w : words) {
            tmap.put(w, tmap.getOrDefault(w, 0) + 1);
        }

        int wordLen = words[0].length();
        int totalWords = words.length;
        int n = s.length();

        List<Integer> ans = new ArrayList<>();

        for (int k = 0; k < wordLen; k++) {
            HashMap<String, Integer> map = new HashMap<>();
            int left = k, right = k;
            int count = 0;

            while (right + wordLen <= n) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (tmap.containsKey(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    count++;

                    // shrink if frequency exceeds
                    while (map.get(word) > tmap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        map.put(leftWord, map.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // valid window
                    if (count == totalWords) {
                        ans.add(left);

                        // move window forward
                        String leftWord = s.substring(left, left + wordLen);
                        map.put(leftWord, map.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                } else {
                    // reset
                    map.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return ans;
    }
}
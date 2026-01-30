class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++){
            st.add(wordList.get(i));
        }
        if (!st.contains(endWord)) return 0;
        st.remove(beginWord);
        while(!queue.isEmpty()){
            String word = queue.peek().first;
            int step = queue.peek().second;
            queue.remove();
            if(word.equals(endWord)){
                return step;
            }
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char replacechararray[] = word.toCharArray();
                    replacechararray[i] = ch;
                    String replaceword = new String(replacechararray);
                    if(st.contains(replaceword) == true){
                        st.remove(replaceword);
                        queue.add(new Pair(replaceword,step + 1));
                    }
                }
            }
        }
        return 0;
    }
}
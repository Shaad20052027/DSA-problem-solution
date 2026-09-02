class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        int maxFreq = 0;
        for(int count : freq){
            maxFreq = Math.max(maxFreq, count);
        }
        int maxFreqTasks = 0;
        for(int count : freq){
            if(count == maxFreq){
                maxFreqTasks++;
            }
        }
        int skeleton = (maxFreq - 1) * (n + 1) + maxFreqTasks;

        return Math.max(tasks.length, skeleton);
    }
}
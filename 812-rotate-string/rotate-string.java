class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        String doublestr = s + s;
        return doublestr.contains(goal);
    }
}
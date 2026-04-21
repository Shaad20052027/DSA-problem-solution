class Solution {
    public boolean checkValidString(String s) {
        int minopen = 0, maxopen = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                minopen++;
                maxopen++;
            }
            else if(ch == ')'){
                minopen--;
                maxopen--;
            }
            else{
                minopen--;
                maxopen++;
            }
            if(minopen < 0){
                minopen = 0;
            }
            if(maxopen < 0){
                return false;
            }
        }
        return (minopen == 0);
    }
}
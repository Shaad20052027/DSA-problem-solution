class Solution {
    public int myAtoi(String s) {
        return helper(s,0,0,1,false);
    }
    private int helper(String s, int index, long result, int sign, boolean started){
        if(index == s.length()){
            return (int)result*sign;
        }

        char c = s.charAt(index);
        if(!started && c==' '){
            return helper(s,index+1,result,sign,false);
        }

        if(!started && (c == '+' || c == '-')){
            sign = (c == '-')?-1:1;
            return helper(s,index+1,result,sign,true);
        }
        if(!Character.isDigit(c)){
            return (int)result*sign;
        }
        result = result*10 + (c - '0');

        if(sign == 1 && result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        if(sign == -1 && -result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return helper(s,index+1,result,sign,true);
    }
}
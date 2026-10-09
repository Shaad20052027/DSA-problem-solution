class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int bitcount = 0; bitcount < 32; bitcount++){
            int cnt = 0;
            for(int i = 0; i < nums.length; i++){
                if((nums[i] & (1 << bitcount)) != 0) cnt++;
            }
            if(cnt % 3 == 1){
                ans = ans | (1 << bitcount);
            }
        }
        return ans;
    }
}
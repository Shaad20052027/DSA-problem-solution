class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, maxlen = 0;
        int countzero = 0;
        while(r < n){
            if(nums[r] == 0){
                countzero++;
            }
            if(countzero > k){
                if(nums[l] == 0){
                    countzero--;
                }
                l++;
            }
            maxlen  = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}
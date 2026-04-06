class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k - 1);
    }
    public int atmost(int[] nums, int k){
        int count = 0, odd = 0, i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] % 2 == 1){
                odd++;
            }
            while(odd > k){
                if(nums[i] % 2 == 1){
                    odd--;
                    
                }
                i++;
                
            }
            count += (j - i + 1);
        }
        return count;
    }
}
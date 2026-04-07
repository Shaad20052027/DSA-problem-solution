class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }
    int atmost(int[] nums, int k){
        int i = 0, j =0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j < nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0) + 1);
            while(map.size() > k){
                int left = nums[i];
                map.put(left,map.get(left) - 1);
                if(map.get(left) == 0){
                    map.remove(left);
                }
                i++;
            }
            count = count + (j-i+1);
            j++;
        }
        return count;
    }
}
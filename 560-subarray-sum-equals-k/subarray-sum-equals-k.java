class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixsum = 0;
        int count = 0;
        map.put(0,1);
        for(int r = 0; r < nums.length; r++){
            prefixsum += nums[r];
            int target = prefixsum - k;
            if(map.containsKey(target)){
                count += map.get(target);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum,0) + 1);
        }
        return count;
    }
}
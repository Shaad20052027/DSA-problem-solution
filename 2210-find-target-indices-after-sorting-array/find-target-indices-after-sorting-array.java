class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            while(i < nums.length && nums[i] == target){
                ans.add(i);
                i++;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
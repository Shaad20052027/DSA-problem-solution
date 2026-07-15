class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, ans, new ArrayList<>(), nums.length);
        return ans;
    }
    private void helper(int idx, int[] arr, List<List<Integer>> ans, ArrayList<Integer> ds, int n){
        ans.add(new ArrayList<>(ds));
        for(int i = idx; i < n; i++){
            if(i != idx && arr[i] == arr[i - 1]) continue;
            ds.add(arr[i]);
            helper(i + 1, arr, ans, ds, n);
            ds.remove(ds.size() - 1);
        }
    }
}
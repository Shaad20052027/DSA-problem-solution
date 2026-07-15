class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];

        helper(nums, freq, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int[] arr, boolean[] freq,
                        List<List<Integer>> ans,
                        ArrayList<Integer> ds) {

        if (ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);

                helper(arr, freq, ans, ds);

                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}
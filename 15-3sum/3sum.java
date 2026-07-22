class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return new ArrayList<>();
        }
        result.clear();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int n1 = nums[i];
            int target = -n1;
            twoSum(nums, target, i + 1, n - 1);
        }
        return result;
    }

    public void twoSum(int[] nums, int target, int i, int j) {
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(-target);
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                while (i < j && nums[i] == nums[i + 1])
                    i++;
                while (i < j && nums[j] == nums[j - 1])
                    j--;

                i++;
                j--;
            }
        }
    }
}
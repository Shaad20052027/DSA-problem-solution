class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int p_idx = findPivot(nums, n);

        int idx = binarySearch(0, p_idx - 1, nums, target);
        if (idx != -1) {
            return idx;
        }

        return binarySearch(p_idx, n - 1, nums, target);
    }

    int findPivot(int[] nums, int n) {
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l; // index of smallest element
    }

    int binarySearch(int l, int r, int[] nums, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
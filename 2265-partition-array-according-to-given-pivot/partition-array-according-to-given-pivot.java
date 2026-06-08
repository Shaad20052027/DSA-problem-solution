class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> great = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                less.add(nums[i]);
            }else if(nums[i] > pivot){
                great.add(nums[i]);
            }else if(nums[i] == pivot){
                equal.add(nums[i]);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(less);
        ans.addAll(equal);
        ans.addAll(great);
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
class Solution {
    public int[] runningSum(int[] nums) {
       ArrayList<Integer> ans = new ArrayList<>();
       int start = 0, end = 0;
       while(end < nums.length){
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += nums[i];
        }
        ans.add(sum);
        end++;
       }
       int[] result = new int[nums.length];
       for(int i = 0; i < ans.size(); i++){
        result[i] = ans.get(i);
       }
       return result;
    }
}
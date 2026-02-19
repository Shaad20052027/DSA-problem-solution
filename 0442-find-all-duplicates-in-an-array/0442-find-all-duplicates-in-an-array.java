class Solution {
   
    public List<Integer> findDuplicates(int[] nums) {
        int i=0;
        while(i < nums.length)
        {
            int correct = nums[i]-1;
            if(nums[i] != nums[correct])
            {
                swap(nums,i,correct);               
            }
            else{
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int index =0;index < nums.length;index++)
        {
            if(nums[index]!= index+1)
            ans.add(nums[index]);
        }
        return ans;
    }
    void swap(int[] arr,int i,int j)
    {
        int temp =0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
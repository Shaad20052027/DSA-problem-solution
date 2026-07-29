class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        return bianrySearch(0, n - 1, target, letters);
    }
    private char bianrySearch(int start, int end, char target, char[] arr){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return arr[start % arr.length];
    }

}
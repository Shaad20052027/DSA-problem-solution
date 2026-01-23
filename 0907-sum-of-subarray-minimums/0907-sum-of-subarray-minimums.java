class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nsl = getNSL(arr,n);
        int[] nsr = getNSR(arr,n);
        int mod = (int)1e9 + 7;
        long sum = 0;
        for(int i = 0; i < n; i++){
            long ls = i - nsl[i];
            long rs = nsr[i] - i;

            long totalways = ls * rs;
            long totalsum = arr[i] * totalways;

            sum = (sum + totalsum)%mod;
        }
        return (int)sum;
    }
    int[] getNSL(int[] arr,int n){
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(stack.isEmpty()){
                result[i] = -1;
            }
            else{
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                    stack.pop();
                }
                result[i] = stack.isEmpty() ? -1 : stack.peek();
                
            }
            stack.push(i);
        }
        return result;
    }

    int[] getNSR(int[] arr,int n){
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            if(stack.isEmpty()){
                result[i] = n;
            }
            else{
                while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                    stack.pop();
                }
                result[i] = stack.isEmpty() ? n : stack.peek();
                
            }
            stack.push(i);
        }
        return result;
    }
}

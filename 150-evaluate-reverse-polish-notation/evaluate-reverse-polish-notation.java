
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String num : tokens) {
            if (!num.equals("+") && !num.equals("-") &&
                !num.equals("/") && !num.equals("*")) {

                st.push(Integer.parseInt(num));

            } else {
                if (num.equals("+")) {
                    int num2 = st.pop();
                    int num1 = st.pop();
                    int sum = num1 + num2;
                    st.push(sum);
                }
                else if (num.equals("-")) {
                    int num2 = st.pop();
                    int num1 = st.pop();
                    int sum = num1 - num2;
                    st.push(sum);
                }
                else if (num.equals("*")) {
                    int num2 = st.pop();
                    int num1 = st.pop();
                    int sum = num1 * num2;
                    st.push(sum);
                }
                else if (num.equals("/")) {
                    int num2 = st.pop();
                    int num1 = st.pop();
                    int sum = num1 / num2;
                    st.push(sum);
                }
            }
        }

        return st.pop();
    }
}

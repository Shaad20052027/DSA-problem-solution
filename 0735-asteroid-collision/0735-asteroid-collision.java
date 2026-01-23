import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!st.isEmpty() && a < 0 && st.peek() > 0) {
                if (Math.abs(a) > st.peek()) {
                    st.pop(); // top asteroid is smaller, it explodes
                    continue;
                } else if (Math.abs(a) == st.peek()) {
                    st.pop(); // both destroy each other
                }
                destroyed = true; // current asteroid is destroyed
                break;
            }

            if (!destroyed) {
                st.push(a);
            }
        }

        // convert stack to array
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}

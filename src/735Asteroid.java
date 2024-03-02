import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class _735Asteroid {
    public static int[] asteroidCollision(int[] A) {

        Stack<Integer> st = new Stack<>();

        st.push(A[0]);

        for (int i = 1; i < A.length; ++i) {

            if (st.empty()) {
                st.push(A[i]);
            } else {
                Integer y = A[i];
                Integer x = st.pop();
                if ((y < x) && (x ^ y) < 0) {
                    if (Math.abs(x) < Math.abs(y)) {
                        st.push(y);
                    } else if (Math.abs(x) > Math.abs(y)) {
                        st.push(x);
                    }

                    y = (!st.empty()) ? st.pop() : null;
                    x = (!st.empty()) ? st.pop() : null;

                    while (x != null && y != null && (y < x) && (x ^ y) < 0) {
                        if (Math.abs(x) < Math.abs(y)) {
                            st.push(y);
                        } else if (Math.abs(x) > Math.abs(y)) {
                            st.push(x);
                        }

                        y = (!st.empty()) ? st.pop() : null;
                        x = (!st.empty()) ? st.pop() : null;
                    }

                    if (x != null) {
                        st.push(x);
                    }
                    if (y != null) {
                        st.push(y);
                    }
                } else {
                    st.push(x);
                    st.push(y);
                }
            }
        }

        List<Integer> ans = new ArrayList(st);

        return ans.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        int A[] = new int[] { 1,1,-2,-2 };

        int ans[] = asteroidCollision(A);

        for (int i = 0; i < ans.length; ++i) {
            System.out.println(ans[i]);
        }

    }
}

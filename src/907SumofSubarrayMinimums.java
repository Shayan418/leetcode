import java.util.Stack;

class _907SumofSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int MOD = (int) 1e9 + 7;

        int[] minleft = new int[arr.length];
        int[] minright = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; ++i) {
            while (!st.empty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                minleft[i] = -1;
            } else {
                minleft[i] = st.peek();
            }
            st.add(i);
            // System.out.print( minleft[i] + " ");
        }

        st.clear();
        // System.out.println();

        for (int i = arr.length - 1; i >= 0; --i) {
            while (!st.empty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                minright[i] = arr.length;
            } else {
                minright[i] = st.peek();
            }
            st.add(i);
        }

        long ans = 0L;
        // for(int i = 0; i< arr.length; ++i){
        // System.out.print( minright[i] + " ");
        // }
        // System.out.println();
        for (int i = 0; i < arr.length; ++i) {
            long contri = 0L;
            contri = (i - minleft[i]) * (minright[i] - i);
            ans = ans + (arr[i] * contri);
            // System.out.println( arr[i] + " " + contri + " " + ans );
        }

        return (int) (ans % MOD);
    }

    public int sumSubarrayMaxs(int[] arr) {
        int MOD = (int) 1e9 + 7;

        int[] maxleft = new int[arr.length];
        int[] maxright = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; ++i) {
            while (!st.empty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                maxleft[i] = -1;
            } else {
                maxleft[i] = st.peek();
            }
            st.add(i);
            //System.out.print( maxleft[i] + " ");
        }

        st.clear();
        //System.out.println();

        for (int i = arr.length - 1; i >= 0; --i) {
            while (!st.empty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                maxright[i] = arr.length;
            } else {
                maxright[i] = st.peek();
            }
            st.add(i);
        }

        long ans = 0L;
        // for(int i = 0; i< arr.length; ++i){
        // System.out.print( maxright[i] + " ");
        // }
        // System.out.println();
        for (int i = 0; i < arr.length; ++i) {
            long contri = 0L;
            contri = (i - maxleft[i]) * (maxright[i] - i);
            ans = ans + (arr[i] * contri);
            //System.out.println( arr[i] + " " + contri + " " + ans );
        }

        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        _907SumofSubarrayMinimums ob = new _907SumofSubarrayMinimums();

        int[] A = { -69,-70,-56,-83,63 };

        System.out.println(ob.sumSubarrayMins(A));
        System.out.println(ob.sumSubarrayMaxs(A));

    }
}

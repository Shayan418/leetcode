class _229MajorityElementII {
    public int repeatedNumber(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        int n1 = -1;
        int c1 = 0;
        int n2 = -1;
        int c2 = 0;

        for (int i = 0; i < A.length; ++i) {
            if (c1 == 0 && n2 != A[i]) {
                c1 = 1;
                n1 = A[i];
            } else if (c2 == 0 && n1 != A[i]) {
                c2 = 1;
                n2 = A[i];
            } else if (A[i] == n1) {
                ++c1;
            } else if (A[i] == n2) {
                ++c2;
            } else {
                --c1;
                --c2;
            }
        }

        c1 = 0;
        c2 = 0;

        for (int n : A) {
            if (n == n1) {
                ++c1;
            } else if (n == n2) {
                ++c2;
            }
        }

        if (c1 >= A.length / 3) {
            return n1;
        }

        if (c2 >= A.length / 3) {
            return n2;
        }

        return -1;

    }

    public static void main(String[] args) {
        _229MajorityElementII ob = new _229MajorityElementII();

        System.out.println(ob.repeatedNumber(new int[] { 1, 1, 1, 2, 3, 5, 7 }));
    }

}

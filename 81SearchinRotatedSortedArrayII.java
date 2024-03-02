class _81SearchinRotatedSortedArrayII {
    public static boolean search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        int mid = 0;

        while (lo <= hi) {
            mid = (hi - lo) / 2 + lo;

            if (mid != A.length - 1 && A[mid] == A[mid + 1]) {
                ++mid;
                while (mid < A.length - 1 && A[mid - 1] == A[mid]) {
                    ++mid;
                }

                if (mid == A.length - 1 && A[0] == A[A.length - 1]) {
                    mid = 1;
                    while (mid < A.length - 1 && A[mid - 1] == A[mid]) {
                        ++mid;
                    }
                }
            }

            if (A[mid] == target) {
                return true;
            }

            if (A[mid] < A[0]) {
                if (target >= A[0]) {
                    hi = mid - 1;
                } else {
                    if (A[mid] < target) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }

            if (A[mid] > A[0]) {
                if (target < A[0]) {
                    lo = mid + 1;
                } else {
                    if (A[mid] < target) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }

            if (A[mid] == A[0]) {
                lo = mid + 1;
            }

        }

        return false;

    }

    public static void main(String[] args) {
         int[] A = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        //int[] A = new int[] { 1, 0, 1, 1, 1 };

        System.out.println(search(A, 2));
    }
}

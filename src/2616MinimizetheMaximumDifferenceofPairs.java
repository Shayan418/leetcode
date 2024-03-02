import java.util.Arrays;
import java.util.HashSet;

class _2616MinimizetheMaximumDifferenceofPairs {

    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];

        int mid = -1;

        int ans = -1;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            int count = 0;
            int min = Integer.MIN_VALUE;

            int l = 0;
            int r = 1;
            int skips = 0;
            HashSet<Integer> hs = new HashSet<>();

            while (r < nums.length) {
                if (r < nums.length - 1 && nums[r + 1] - nums[l + 1] < nums[r] - nums[l]) {
                    ++l;
                    ++r;
                    ++skips;
                }
                int diff = nums[r] - nums[l];

                if (diff <= mid) {
                    ++count;
                    if (count > p && hs.contains(diff)) {
                        --count;
                    }
                    hs.add(diff);
                    min = Math.max(min, diff);
                }

                l += 2;
                r += 2;
            }
            System.out.println("Skips" + skips);

            if (count <= p) {
                lo = mid + 1;
                ans = Math.max(ans, min);
            } else {
                hi = mid - 1;

            }

        }

        return ans;

    }

    public static void main(String[] args) {
        int[] A = new int[] { 10, 1, 2, 7, 1, 3 };
        // System.out.println(minimizeMax(A, 2));

        int[] B = new int[] { 4, 0, 2, 1, 2, 5, 5, 3 };
        // System.out.println(minimizeMax(B, 3));

        int[] C = new int[] { 3, 4, 2, 3, 2, 1, 2 };
        System.out.println(minimizeMax(C, 3));

        int[] D = new int[] { 4, 2, 1, 2 };
        //System.out.println(minimizeMax(D, 1));
    }
}

class _930BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {

        int l = 0;
        int r = 0;
        int sum = nums[r];

        while (sum < goal && r < nums.length - 1) {
            ++r;
            if (r == nums.length) {
                break;
            }
            sum += nums[r];
        }

        int ans = 0;
        while (l < nums.length && r < nums.length) {
            if (sum == goal) {
                while (nums[l] == 0 && l < r) {
                    ++l;
                }
                int lz = 1;
                int rz = 1;
                int idx = l - 1;
                while (idx >= 0 && nums[idx] == 0) {
                    ++lz;
                    --idx;
                }
                idx = r + 1;
                while (idx < nums.length && nums[idx] == 0) {
                    ++rz;
                    ++idx;
                }

                ans += lz * rz;

                sum -= nums[l];
                nums[l] = 1;
                ++l;

                ++r;
                if (r == nums.length) {
                    break;
                }
                sum += nums[r];
            } else if (sum < goal) {
                ++r;
                if (r == nums.length) {
                    break;
                }
                sum += nums[r];
            } else if (sum > goal) {
                sum -= nums[l];
                nums[l] = 1;
                ++l;

                if (r < l) {
                    ++r;
                    if (r == nums.length) {
                        break;
                    }
                    sum += nums[r];
                }
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 2));
        System.out.println(numSubarraysWithSum(new int[] { 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0 }, 0));
        System.out.println(numSubarraysWithSum(new int[] { 0, 0, 1, 0, 0 }, 0));
    }
}

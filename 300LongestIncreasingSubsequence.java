class _300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];

        int ans = 0;

        for (int i = 0; i < nums.length; ++i) {
            dp[i] = solve2(nums, i, dp);
        }

        for (int n : dp) {
            ans = Math.max(ans, n);
        }

        return ans;

    }

    public int solve(int[] nums, int idx, int[] dp) {
        if (idx == 0) {
            return 1;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        int ans = 0;
        for (int i = 0; i < idx; ++i) {
            if (nums[i] < nums[idx]) {
                ans = Math.max(ans, solve(nums, i, dp));
            }
        }

        return dp[idx] = ans + 1;
    }

    public int solve2(int[] nums, int idx, int[] dp) {

        if (idx == nums.length) {
            return 0;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        int ans = 0;
        for (int i = idx + 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                ans = Math.max(ans, solve2(nums, i, dp));
            }
        }

        return dp[idx] = ans+1;

    }

    public static void main(String[] args) {
        _300LongestIncreasingSubsequence ob = new _300LongestIncreasingSubsequence();

        System.out.println(ob.lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
        System.out.println(ob.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));

    }

}

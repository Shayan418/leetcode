class _279PerfectSquare {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];

        return helper(n, dp);

    }

    public int helper(int n, int[] dp) {
        if (n <= 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int min = n;

        for (int i = 1; i * i <= n; ++i) {
            min = Math.min(min, helper(n - (i * i), dp));
        }

        return dp[n] = min + 1;

    }

    public static void main(String[] args) {
        _279PerfectSquare ob = new _279PerfectSquare();

        System.out.println(ob.numSquares(12));
    }
}

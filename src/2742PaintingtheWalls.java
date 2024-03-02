class _2742PaintingtheWalls {
    public int paintWalls(int[] cost, int[] time) {

        int[][] dp = new int[cost.length + 1][cost.length + 1];

        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                dp[i][j] = -1;
            }
        }

        return helper(cost, time, 0, cost.length, dp);
    }

    public int helper(int[] cost, int[] time, int idx, int rem, int[][] dp) {

        if (rem <= 0) {
            return 0;
        }

        if (idx == cost.length) {
            return 10000000;
        }

        if (dp[idx][rem] != -1) {
            return dp[idx][rem];
        }

        int take = cost[idx] + helper(cost, time, idx + 1, rem - 1 - time[idx], dp);
        int skip = helper(cost, time, idx + 1, rem, dp);

        return dp[idx][rem] = Math.min(take, skip);
    }

    public static void main(String[] args) {
        _2742PaintingtheWalls ob = new _2742PaintingtheWalls();

        System.out.println(ob.paintWalls(new int[] { 1, 2, 3, 2 }, new int[] { 1, 2, 3, 2 }));
    }
}
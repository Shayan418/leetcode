import java.util.Arrays;

public class _1289MinimumFallingPathSumII {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid.length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < grid.length; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            dp[grid.length - 1][i] = grid[grid.length - 1][i];
        }

        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = 0; j < grid.length ; j++) {
                int minRes = Integer.MAX_VALUE;
                for(int k = 0; k < grid.length; k++) {
                    if(k ==j)
                        continue;
                    minRes = Math.min(minRes, dp[i+1][k]);
                }
                dp[i][j] = grid[i][j] + minRes;
            }
        }

        return Arrays.stream(dp[0]).min().getAsInt();
    }

    public static void main(String[] args) {
        _1289MinimumFallingPathSumII ob = new _1289MinimumFallingPathSumII();

        // int[][] grid = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] grid = new int[][] { { -73, 61, 43, -48, -36 }, { 3, 30, 27, 57, 10 }, { 96, -76, 84, 59, -15 },
                { 5, -49, 76, 31, -7 }, { 97, 91, 61, -46, 67 } };

        System.out.println(ob.minFallingPathSum(grid));
    }
}

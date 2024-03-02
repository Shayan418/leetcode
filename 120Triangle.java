import java.util.ArrayList;
import java.util.Arrays;

class _120Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> tr) {

        int colsize = tr.get(tr.size() - 1).size();

        int[][] dp = new int[tr.size()][colsize];

        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                dp[i][j] = -1;
            }
        }

        int lastrow = tr.size() - 1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < colsize; ++i) {
            ans = Math.min(ans, helper(dp, i, lastrow, tr));
        }

        return ans;

    }

    public int helper(int[][] dp, int col, int row, ArrayList<ArrayList<Integer>> tr) {
        if (row == 0) {
            return tr.get(0).get(0);
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        if (col == 0) {
            return dp[row][col] = tr.get(row).get(col) + helper(dp, col, row - 1, tr);
        }

        if (col == tr.get(row).size() - 1) {
            return dp[row][col] = tr.get(row).get(col) + helper(dp, col - 1, row - 1, tr);
        }

        return dp[row][col] = Math.min(tr.get(row).get(col) + helper(dp, col, row - 1, tr),
                tr.get(row).get(col) + helper(dp, col - 1, row - 1, tr));
    }

    public static void main(String[] args) {
        _120Triangle ob = new _120Triangle();

        ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(2)),
                new ArrayList<Integer>(Arrays.asList(6, 6)),
                new ArrayList<Integer>(Arrays.asList(7, 8, 4))
        ));

        System.out.println(ob.minimumTotal(A));
    }
}

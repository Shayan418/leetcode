import java.util.ArrayList;
import java.util.List;

public class _1992FindAllGroupsofFarmland {
    int x, y;

    _1992FindAllGroupsofFarmland() {
        x = 0;
        y = 0;
    }

    public int[][] findFarmland(int[][] land) {
        List<int[]> ansList = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    dfs(land, i, j);
                    ansList.add(new int[] { i, j, x, y });
                    x = 0;
                    y = 0;
                }
            }
        }

        return ansList.stream().toArray(int[][]::new);
    }

    public void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        x = Math.max(x, row);
        y = Math.max(y, col);
        grid[row][col] = 0;
        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
    }

    // public int[] findbottomright(int row, int col, int[][] land) {
    // int[] ans = new int[] { row, col };

    // while (row + 1 < land.length && col + 1 < land[0].length && land[row + 1][col
    // + 1] == 1
    // && land[row][col + 1] == 1 && land[row + 1][col] == 1) {
    // ans[0] = row + 1;
    // ans[1] = col + 1;
    // ++row;
    // ++col;
    // }

    // while (row + 1 < land.length && land[row + 1][col] == 1) {
    // ans[0] = row + 1;
    // ans[1] = col;
    // ++row;
    // }

    // while (col + 1 < land[0].length && land[row][col + 1] == 1) {
    // ans[0] = row;
    // ans[1] = col + 1;
    // ++col;
    // }

    // return ans;
    // }

    // public void dfs(int[][] grid, int row, int col) {
    // if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||
    // grid[row][col] == 0) {
    // return;
    // }

    // grid[row][col] = 0;
    // dfs(grid, row - 1, col);
    // dfs(grid, row + 1, col);
    // dfs(grid, row, col - 1);
    // dfs(grid, row, col + 1);

    // }

    public static void main(String[] args) {
        _1992FindAllGroupsofFarmland ob = new _1992FindAllGroupsofFarmland();
        int[][] a = new int[][] { { 1, 0, 0 }, { 0, 1, 1 }, { 0, 1, 1 } };

        int ans[][] = ob.findFarmland(a);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.err.print(ans[i][j] + " ");
            }
            System.err.println();
        }

    }
}

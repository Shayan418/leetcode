public class _1905CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {

        boolean[][] visited = new boolean[grid1.length][grid1[0].length];
        int ans = 0;

        for (int i = 0; i < grid1.length; ++i) {
            for (int j = 0; j < grid1[0].length; ++j) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    if (dfs(grid1, grid2, visited, i, j)) {
                        ++ans;
                        System.out.println(i + " " + j);
                    }
                }
            }
        }

        for (int i = 0; i < grid1.length; ++i) {
            for (int j = 0; j < grid1[0].length; ++j) {
                System.out.print((visited[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }

        return ans;

    }

    public boolean dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int row, int col) {

        if (grid1[row][col] == 0) {
            return false;
        }
        
        visited[row][col] = true;

        int[] x = new int[] { 0, 0, 1, -1 };
        int[] y = new int[] { 1, -1, 0, 0 };

        boolean ans = true;
        for (int i = 0; i < 4; ++i) {
            int newRow = row + x[i];
            int newCol = col + y[i];

            if (newRow >= 0 && newCol >= 0 && newRow < grid1.length && newCol < grid1[0].length
                    && grid2[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                ans = ans & dfs(grid1, grid2, visited, newRow, newCol);
            }

        }


        return ans;
    }

    public boolean dfs2(int[][] grid1, int[][] grid2, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= grid1.length || col >= grid1[0].length || 
            grid2[row][col] == 0 || visited[row][col]) {
            return true;
        }
        
        visited[row][col] = true;
        boolean isSubIsland = (grid1[row][col] == 1);
    
        isSubIsland &= dfs(grid1, grid2, visited, row + 1, col);
        isSubIsland &= dfs(grid1, grid2, visited, row - 1, col);
        isSubIsland &= dfs(grid1, grid2, visited, row, col + 1);
        isSubIsland &= dfs(grid1, grid2, visited, row, col - 1);
        
        return isSubIsland;
    }

    public static void main(String[] args) {
        _1905CountSubIslands ob = new _1905CountSubIslands();

        // int[][] grid1 = new int[][]{{1,1,1,0,0},
        // {0,1,1,1,1},
        // {0,0,0,0,0},
        // {1,0,0,0,0},
        // {1,1,0,1,1}};
        // int[][] grid2 = new int[][]{{1,1,1,0,0},
        // {0,0,1,1,1},
        // {0,1,0,0,0},
        // {1,0,1,1,0},
        // {0,1,0,1,0}};

        int[][] grid1 = new int[][] {
                { 1, 1, 1, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 0 },
                { 1, 0, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 1, 1 },
                { 1, 0, 0, 0, 1, 0 },
                { 1, 1, 1, 1, 1, 0 } };
        int[][] grid2 = new int[][] {
                { 1, 1, 1, 1, 0, 1 },
                { 0, 0, 1, 0, 1, 0 },
                { 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 1 },
                { 1, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 0, 0 } };
        System.out.println(ob.countSubIslands(grid1, grid2));

    }

}

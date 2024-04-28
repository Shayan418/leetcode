public class _200NumberofIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++ans;
                }
            }
        }

        return ans;
    }

    public void dfs(char[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

    }



    public static void main(String[] args) {
        
        _200NumberofIslands ob = new _200NumberofIslands();

        char a[][] = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        System.out.println(ob.numIslands(a));
    }
}

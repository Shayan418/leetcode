class _1463CherryPickupII {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];


        return helper(dp, grid, 0, 0, cols -1);

    }


    public int helper(int[][][] dp, int [][] grid, int r, int c1, int c2){
        if(c1 == c2 || Math.min(c1, c2) < 0 || Math.max(c1, c2) >= grid[0].length){
            return Integer.MIN_VALUE;
        }
        if(r == grid.length - 1){
            return grid[r][c1] + grid[r][c2];
        }

        if(dp[r][c1][c2] != 0){
            return dp[r][c1][c2];
        }
        
        int[] x = new int[]{-1, 0, 1};

        int ans = 0;

        for(int i = 0; i < 3; ++i){
            int newc1 = c1 + x[i];
            for(int j = 0; j < 3; ++j){
                int newc2 = c2 + x[j];
                ans = Math.max(ans, helper(dp, grid, r+1, newc1, newc2));
            }
        }
        

        return dp[r][c1][c2] = ans + grid[r][c1] + grid[r][c2];
    }

    public static void main(String[] args) {
        _1463CherryPickupII ob = new _1463CherryPickupII();

        int[][] A = new int[][] {
                { 3, 1, 1 }, 
                { 2, 5, 1 }, 
                { 1, 5, 5 }, 
                { 2, 1, 1 }
        };

        System.out.println(ob.cherryPickup(A));
    }

}

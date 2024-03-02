class _1155NumberofDiceRollsWithTargetSum {
    int MOD = (int) 1e9 + 7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];

        for(int i = 0; i< dp.length; ++i){
            for(int j = 0; j < dp[0].length; ++j){
                dp[i][j] = -1;
            }
        }
        
        return helper(n,k,target, dp, 0);

    }

    public int helper(int n, int k, int target, int[][] dp, int ways){
        if(target == 0 && n == 0){
            return 1;
        }

        if(target < 0 || n == 0){
            return 0;
        }

        if(dp[n][target] != -1){
            return dp[n][target];
        }

        int ans = 0;
        for(int i = 1; i <= k; ++i){
            ans = (ans % MOD + helper(n-1, k, target-i, dp, ways) % MOD) % MOD;
        }

        return dp[n][target] = (ans+ways) % MOD;

    }
    
    public static void main(String[] args) {
        _1155NumberofDiceRollsWithTargetSum ob = new _1155NumberofDiceRollsWithTargetSum();
        System.out.println(ob.numRollsToTarget(30,30,500));
    }
}

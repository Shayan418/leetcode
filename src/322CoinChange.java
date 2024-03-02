class _322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int ans = helper(coins, amount, dp);
        return (ans > 10000) ? -1 : ans;
    }

    public int helper(int[] coins, int sum, int[] dp){
        if(sum == 0){
           return 0;
        }

        if(sum < 0){
            return 1000000;
        }

        if(dp[sum] != 0){
            return dp[sum];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; ++i){
            ans = Math.min(ans, helper(coins, sum - coins[i], dp));
        }

        return dp[sum] = ans + 1;
    }
    
    public static void main(String[] args) {
        _322CoinChange ob = new _322CoinChange();
        System.out.println(ob.coinChange(new int[]{1,2,5}, 11));
    }
}

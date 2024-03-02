class _1043PartitionArrayforMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int[] dp = new int[arr.length];
        return helper(arr, k, 0, dp);

    }


    public int helper(int[] arr, int k, int idx, int[] dp){
        
        if(idx >= arr.length){
            return 0;
        }

        if(dp[idx] != 0){
            return dp[idx];
        }

        int ans = 0;
        int cmax = 0;
        for(int i = idx; i < Math.min(arr.length, idx + k); ++i){
            cmax = Math.max(cmax, arr[i]);
            ans = Math.max(ans, helper(arr, k, i+1, dp) + (cmax * (i - idx + 1)));
        }
        

        return dp[idx] = ans;
    }
    
    public static void main(String[] args) {
        _1043PartitionArrayforMaximumSum ob = new _1043PartitionArrayforMaximumSum();

        System.out.println(ob.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10 }, 3));
    }
}

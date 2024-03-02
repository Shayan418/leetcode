class _1335MinimumDifficultyofaJobSchedule {
    public int minDifficulty(int[] job, int day) {

        int[][] dp = new int[job.length + 1][day + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                dp[i][j] = -1;
            }
        }

        return helper(job, dp, 0, day, -1);

        

    }

    public int helper(int[] job, int[][] dp, int idx, int curr, int prev) {
        
        if (idx == job.length && curr == 0) {
            return 0;
        }

        if (idx >= job.length || curr <= 0) {
            return Integer.MAX_VALUE;
        }

        // if (dp[idx][curr] != -1) {
        //     return dp[idx][curr];
        // }

        prev = Math.max(prev, job[idx]);

        int movedate = helper(job, dp, idx+1, curr-1, -1);
        movedate = movedate + ((movedate == Integer.MAX_VALUE) ? 0 : prev);
        int keepdate = helper(job, dp, idx+1, curr, prev);
        

        dp[idx][curr] = Math.min(movedate, keepdate);

        return dp[idx][curr];
    }

    public static void main(String[] args) {
        _1335MinimumDifficultyofaJobSchedule ob = new _1335MinimumDifficultyofaJobSchedule();

        System.out.println(ob.minDifficulty(new int[] { 6,5,4,3,2,1 }, 2));
        System.out.println(ob.minDifficulty(new int[] { 1, 1, 1 }, 3));
        System.out.println(ob.minDifficulty(new int[] { 7,1,7,1,7,1 }, 3));

    }
}

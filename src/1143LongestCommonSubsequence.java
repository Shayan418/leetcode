class _1143LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < dp.length; ++i)
            for(int j = 0 ; j < dp[0].length; ++j)
                dp[i][j] = -1;
        
        return helper(text1, text2, 0, 0, dp);

        
    }

    public int helper(String t1, String t2, int i1, int i2, int[][] dp){
        if(i1 == t1.length() || i2 == t2.length()){
            return 0;
        }

        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }

        int ans = 0;
        if(t1.charAt(i1) == t2.charAt(i2)){
            ++ans;
            ans += helper(t1, t2, i1+1, i2+1, dp); 
        } else {
            ans += Math.max(helper(t1, t2, i1+1, i2, dp), helper(t1, t2, i1, i2+1, dp));
        }
        
        return dp[i1][i2] = ans;
    }

    public static void main(String[] args) {
        _1143LongestCommonSubsequence ob = new _1143LongestCommonSubsequence();

        System.out.println(ob.longestCommonSubsequence("bbbab", "babbb"));
        System.out.println(ob.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }
}

class _97InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];


        return helper(s1,s2,s3,0,0,0, dp);

    }


    public boolean helper(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp){
        if(i == s1.length() && j == s2.length() && k == s3.length()){
            return true;
        }

        if(k == s3.length()){
            return false;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        boolean s1match = false;
        boolean s2match = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            s1match = helper(s1,s2,s3, i+1, j,  k+1, dp);
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            s2match = helper(s1,s2,s3, i, j+1,  k+1, dp);
        }

        return dp[i][j] = s1match || s2match;

    }
    
    public static void main(String[] args) {
        _97InterleavingString ob= new _97InterleavingString();

        //System.out.println(ob.isInterleave("", "", "a"));
        //System.out.println(ob.isInterleave("a", "b", "a"));
        System.out.println(ob.isInterleave("aabc", "abad", "aabcabad"));
        System.out.println(ob.isInterleave("accbaabaaabbcbaacbababacaababbcbabaababcaabbbbbcacbaa", "cabaabcbabcbaaaacababccbbccaaabaacbbaaabccacabaaccbbcbcb", "accbcaaabbaabaaabbcbcbabacbacbababaacaaaaacbabaabbcbccbbabbccaaaaabaabcabbcaabaaabbcbcbbbcacabaaacccbbcbbaacb"));
    }
}

class _10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        
        Boolean[][] dp = new Boolean[s.length()+1][p.length()];

        //System.out.print(sb.toString());
        return helper(s, p, s.length()-1, p.length()-1, dp);
    }

    public boolean helper(String s, String p, int i, int j, Boolean[][] dp){
        if(i == -1 && j == -1){
            return true;
        }

        if(j == -1){
            return false;
        }

        if(i == -1){
            while(j >= 1){
                if(p.charAt(j) != '*'){
                    return false;
                }
                j -=2;
            }

            if(j >=0){return false;}

            return true;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' ){
           return dp[i][j] = helper(s, p, i-1, j-1, dp);
        }


        if(p.charAt(j) == '*'){
            if(s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                return dp[i][j] = helper(s, p, i-1, j, dp) || helper(s, p, i, j-2, dp);    
            } else {
                return dp[i][j] = helper(s, p, i, j-2, dp) ;
            }
        }

        return dp[i][j] = false;
    }

    public static void main(String[] args) {
        _10RegularExpressionMatching ob = new _10RegularExpressionMatching();

        System.out.println(ob.isMatch("a", "ab*a"));
    }


}

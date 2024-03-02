class _44WildcardMatching {
    public boolean isMatch(String s, String p) {
        
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i< p.length()){
            sb.append(p.charAt(i));
            ++i;
            while(sb.charAt(sb.length()-1) == '*' && i< p.length() && p.charAt(i) == '*'){
                ++i;
            }
        }

        Boolean[][] dp = new Boolean[s.length()+1][sb.length()];
        
        return solve(s, sb.toString(), s.length() - 1, sb.length() - 1, dp);
    }

    public boolean solve(String s, String p, int i,int j,  Boolean[][] dp){

        if(i == -1 && j == -1){
            return true;
        }

        if(j == -1){
            return false;
        }

        if(i == -1){
            for(int x=0; x<= j ; ++x){
                if(p.charAt(x) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = solve(s,p,i-1,j-1,dp);
        }

        if(p.charAt(j) == '*'){
            return dp[i][j] = ( solve(s,p,i-1,j,dp) || solve(s,p,i,j-1,dp) ) ;
        }


        return dp[i][j] = false;
    }

    public static void main(String[] args) {
        _44WildcardMatching ob = new _44WildcardMatching();

        System.out.println(ob.isMatch("abaabaaaabbabbaaabaabababbaabaabbabaaaaabababbababaabbabaabbbbaabbbbbbbabaaabbaaaaabbaabbbaaaaabbbabb", "ab*aaba**abbaaaa**b*b****aa***a*b**ba*a**ba*baaa*b*ab*"));
    }
}

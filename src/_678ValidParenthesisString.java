
public class _678ValidParenthesisString {
    public boolean checkValidString(String s) {
        int dp[][] = new int[s.length()][s.length()];
        return helper(s, 0, 0, dp);
    }

    public boolean helper(String s, int idx, int diff, int[][] dp) {
        if (idx == s.length()) {
            return (diff == 0);
        }
        if (dp[idx][diff] != 0) {
            return dp[idx][diff] == 1;
        }
        
        int res = -1;
        if (s.charAt(idx) == '(') {
            res = helper(s, idx + 1, diff + 1, dp) == true ? 1 : -1;
        } else if (s.charAt(idx) == ')' && diff > 0) {
            res = helper(s, idx + 1, diff - 1, dp) == true ? 1 : -1;
        } else if (s.charAt(idx) == '*') {
            if (diff > 0) {
                res = (res == 1 || helper(s, idx + 1, diff - 1, dp)) == true ? 1 : -1;
            }
            res = (res == 1 || helper(s, idx + 1, diff, dp) | helper(s, idx + 1, diff + 1, dp)) == true ? 1 : -1;
        }

        dp[idx][diff] = res;
        return res == 1;
    }

    public static void main(String[] args) {
        _678ValidParenthesisString ob = new _678ValidParenthesisString();
        System.out.println(ob.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
        System.out.println(ob.checkValidString("**************************************************))))))))))))))))))))))))))))))))))))))))))))))))))"));
        System.out.println(ob.checkValidString("************************************************************"));
    
    }

}

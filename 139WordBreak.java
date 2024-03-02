import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        
        return solve(s, wordDict, 0);

    }


    public static boolean solve(String s, List<String> wordDict, int idx){
        if(idx >= s.length()){
            return true;
        }


        int sl = s.length() - idx;

        boolean ans = false;

        for(String w: wordDict){
            int wl = w.length();

            if(wl <= sl && w.equals(s.substring(idx, idx + wl)) ){
                ans = (ans == false) ? solve(s, wordDict, idx + wl) : true;
            }

        }

        return ans;

    }

    public static boolean wordBreakDp(String s, List<String> wordDict) {
        
        int sl = s.length();

        boolean[] dp = new boolean[sl + 1];
        dp[sl] = true;

        for(int i=sl - 1; i >= 0; --i){
            for(String w: wordDict){
                int wl = w.length();
                if(wl <= sl - i && w.equals(s.substring(i, i + wl))){
                    dp[i] = (dp[i] == false) ? dp[i + wl] : true;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<String>(Arrays.asList("a","abc","b","cd"));
        System.out.println(wordBreakDp("abcd", l));

        //List<String> l = new ArrayList<String>(Arrays.asList("car","ca","rs"));
        //System.out.println(wordBreakDp("cars", l));
    }


}

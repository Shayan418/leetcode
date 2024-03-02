import java.util.Arrays;

class _1269NumberofWaystoStayintheSamePlaceAfterSomeSteps{
    static final int MOD = (int) 1e9 + 7;

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min((steps / 2) + 1, arrLen);
        int[][] dp = new int[arrLen][steps + 1];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);

        return solve2(steps,0, dp) ;
    }

    public int solve2(int steps, int idx, int[][] dp){
        if(steps < idx){
            return 0;
        }

        if(steps == 0 && idx == 0){
            return 1;
        }

        if(dp[idx][steps] != -1){
            return dp[idx][steps];
        }

        int l=0, r=0,s=0;
        if(idx > 0){
            l = solve2(steps - 1, idx - 1, dp) % MOD;
        }
        
        if(idx < dp.length - 1){
            r = solve2(steps - 1, idx + 1, dp) % MOD;
        }
        

        s = solve2(steps - 1, idx, dp) % MOD;
        
        return dp[idx][steps] = ((l + r) % MOD + s) % MOD;
    }

    public Long solve(int steps, int n, int idx, Long[][] dp){
        if(steps == 0 && idx == 0){
            return 1L;
        }

        if(steps == 0 && idx != 0){
            return null;
        }

        if(dp[steps][idx] != null){
            return dp[steps][idx];
        }

        Long l=null, r=null,s=null;
        if(idx != 0){
            l = solve(steps - 1, n, idx - 1, dp);
        }
        l = (l == null ? 0 : l);

        if(idx != n-1){
            r = solve(steps - 1, n, idx + 1, dp);
        }
        r = (r == null ? 0 : r);


        s = solve(steps - 1, n, idx, dp);
        s = (s == null ? 0 : s);

        return dp[steps][idx] = (l + r + s);
    }


    public static void main(String[] args) {
        _1269NumberofWaystoStayintheSamePlaceAfterSomeSteps ob = new _1269NumberofWaystoStayintheSamePlaceAfterSomeSteps();

        System.out.println(ob.numWays(27,7));
        //System.out.println(ob.numWays(2,4));

        
    }
}
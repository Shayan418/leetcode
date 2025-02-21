

public class _1140StoneGameII {
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[piles.length][piles.length+1][2];

        return helper(1, 1, 0, dp, piles, true);

    }

    public int helper(int x, int m, int l, int[][][] dp, int[] piles, boolean turn) {
        if (l == piles.length) {
            return 0;
        }

        if(dp[l][m][turn == true? 1: 0] > 0){
            return dp[l][m][turn == true? 1: 0];
        }

        int ans = 0;
        if(!turn){ans = Integer.MAX_VALUE;}
        int sum = 0;
        int picked = 0;
        int newl = l;

        while (picked < (2 * m) && newl < piles.length) {
            sum += piles[newl];
            ++newl;
            ++picked;
        
            if (turn) {
                ans = Math.max(ans, helper(picked, Math.max(m, picked), newl, dp, piles, !turn) + sum);
            } else {
                ans = Math.min(ans, helper(picked, Math.max(m, picked), newl, dp, piles, !turn));
            }
        
        }

        return dp[l][m][turn == true? 1: 0] = ans;

    }

    public static void main(String[] args) {
        _1140StoneGameII ob = new _1140StoneGameII();

        System.out.println(ob.stoneGameII(new int[] { 6,4,2,8,1,8,6,6,2 }));
        //System.out.println(ob.stoneGameII(new int[] { 9,2,2,8,3,7,9,9 }));
//        System.out.println(ob.stoneGameII(new int[] { 2, 7, 9, 4, 4 }));
//        System.out.println(ob.stoneGameII(new int[] { 1 }));

        
    }
}

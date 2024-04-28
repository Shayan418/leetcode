public class _514FreedomTrail {
    public int findRotateSteps(String ring, String key) {

        int dp[][] = new int[ring.length()][key.length()];
        return helper(ring, key, 0, 0, dp);

    }

    public int helper(String ring, String key, int idx, int pos, int[][] dp) {
        if (idx == key.length()) {
            return 0;
        }

        if(dp[pos][idx] != 0){
            return dp[pos][idx];
        }

        int ans = Integer.MAX_VALUE;
        int distance;
        
        
        for (int i = pos; i >= 0; --i) {
            if(ring.charAt(i) == key.charAt(idx)){
                distance = (pos - i);
                ans = Math.min(ans, helper(ring, key, idx + 1, i, dp) + distance);                            
            }
        }

        for (int i = ring.length() - 1; i >= pos + (ring.length() / 2); --i) {
            if(ring.charAt(i) == key.charAt(idx)){
                distance = pos + (ring.length() - i);
                ans = Math.min(ans, helper(ring, key, idx + 1, i, dp) + distance);                            
            }
        }
        

        for (int i = pos; i < ring.length(); ++i) {
            if(ring.charAt(i) == key.charAt(idx)){
                distance = i - pos;
                ans = Math.min(ans, helper(ring, key, idx + 1, i, dp) + distance);
            }
        }
        

        for (int i = 0; i <= pos - (ring.length() / 2); ++i) {
            if(ring.charAt(i) == key.charAt(idx)){
                distance = (ring.length() - pos) + i;
                ans = Math.min(ans, helper(ring, key, idx + 1, i, dp) + distance);            
            }
        }

        return dp[pos][idx] = ans + 1;
    }

    public static void main(String[] args) {
        _514FreedomTrail ob = new _514FreedomTrail();

        System.out.println(ob.findRotateSteps("godding", "gd"));
        System.out.println(ob.findRotateSteps("godding", "godding"));
        System.out.println(ob.findRotateSteps("edcba", "abcde"));
    }
}

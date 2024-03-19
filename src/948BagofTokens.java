import java.util.Arrays;

class _948BagofTokens{
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int l = 0;
        int r = tokens.length - 1;
        int score = 0;
        int ans = 0;

        while(l <= r){
            if(power >= tokens[l]){
                ++score;
                power -= tokens[l];
                ++l;
                ans = Math.max(ans, score);
            } else if(score >= 1){
                --score;
                power += tokens[r];
                --r;
            } else {
                break;
            }
        }   

        return ans;
    }
    
    public static void main(String[] args) {
        _948BagofTokens ob = new _948BagofTokens();

        System.out.println(ob.bagOfTokensScore(new int[]{100,200,300,400}, 200));
    }
}
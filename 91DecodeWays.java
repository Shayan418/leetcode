class _91DecodeWays {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }

        if(s.length() == 1){
            return 1;
        }

        int prev = 1;
        int curr = (s.charAt(1) == 0) ? 0 : 1;
        int temp = 0;

        for(int i=2 ; i<= s.length(); ++i){
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigits = Integer.parseInt(s.substring(i-2, i));
            temp = 0;

            if(oneDigit > 0 && oneDigit < 10){
                temp = curr;
            }

            if(twoDigits >= 10 && twoDigits <= 26){
                temp += prev;
            }
            prev = curr;
            curr = temp;
        }

        return curr;

    }

    public int numDecodings2(String s) {
        int[] dp = new int[s.length()+1];

        if(s.charAt(0) == '0'){
            return 0;
        }

        if(s.length() == 1){
            return 1;
        }

        dp[0] = 1;
        dp[1] = (s.charAt(1) == 0) ? 0 : 1;


        for(int i=2 ; i<= s.length(); ++i){

            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigits = Integer.parseInt(s.substring(i-2, i));

            if(oneDigit > 0 && oneDigit < 10){
                dp[i] += dp[i-1];
            }

            if(twoDigits >= 10 && twoDigits <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];

    }

    public static void main(String[] args) {
        _91DecodeWays ob = new _91DecodeWays();
        System.out.println(ob.numDecodings2("20223014"));

    }
}

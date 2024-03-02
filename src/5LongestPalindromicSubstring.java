class _5LongestPalindromicSubstring {
    
    public String longestPalindrome(String s) {
        int ans = 0;
        String ansS = "";
        int len = s.length();
        for(int i=0; i<len; ++i){
            int count = 1;
            int l = i-1;
            int r = i+1;
            while(l>=0 && r <len){
                if(s.charAt(l) == s.charAt(r)  ){
                    count += 2;
                    --l;
                    ++r;
                } else {
                    if(ans < count){
                        ans = count;
                        ansS = s.substring(l+1, r);
                    }
                    break;
                }
            }
            if(ans < count){
                ans = count;
                ansS = s.substring(l+1, r);
            }
            

            count = 0;
            l = i;
            r = i+1;

            while(l>=0 && r <len){
                if(s.charAt(l) == s.charAt(r)){
                    count += 2;
                    --l;
                    ++r;
                } else {
                    if(ans < count){
                        ans = count;
                        ansS = s.substring(l+1, r);
                    }
                    break;
                }

            }
            if(ans < count){
                ans = count;
                ansS = s.substring(l+1, r);
            }


        }

        return ansS;

    }

    public static void main(String[] args) {
        _5LongestPalindromicSubstring ob = new _5LongestPalindromicSubstring();

        System.out.println(ob.longestPalindrome("myoybzfgcillisy"));
    }
}

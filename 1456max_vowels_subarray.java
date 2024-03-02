class _1456max_vowels_subarray {

    public static boolean isVowel(char ch){
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    public static int maxVowels(String s, int k) {

        int count = 0;
        for(int i=0; i<k; ++i){
            if(isVowel(s.charAt(i)))
                ++count;
        }

        int ans = count;
        

        for(int i=1; i<s.length()-k+1; ++i){
            
            if(isVowel(s.charAt(i-1)))
                --count;
            

            if(isVowel(s.charAt(i+k-1)))
                ++count;
            
            ans = Math.max(ans, count);

        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

}
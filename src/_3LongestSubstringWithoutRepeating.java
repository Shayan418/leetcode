public class _3LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String A) {
        if(A.length() == 0){
            return 0;
        }
        
        int l = 0;
        int r = 1;
        int ans = 1;

        int freq[] = new int[256];
        ++freq[A.charAt(l)];

        

        while(r < A.length()){
            ++freq[A.charAt(r)];

            while(freq[A.charAt(r)] > 1 && l < r){
                --freq[A.charAt(l)];
                ++l;
            }
            
            ++r;
            ans = Math.max(ans, r-l);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}

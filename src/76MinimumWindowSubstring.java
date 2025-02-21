import java.util.Arrays;
import java.util.HashMap;

class _76MinimumWindowSubstring {

    public boolean isValid(int[] charArray) {
        return Arrays.stream(charArray).allMatch(n -> n <= 0);
    }

    public String minWindow(String s, String t) {

        int[] charArray = new int[124];

//        for (Character ch : t.toCharArray()) {
//            if (!mp.containsKey(ch)) {
//                mp.put(ch, 0);
//            }
//            mp.put(ch, mp.get(ch) + 1);
//        }

        for (int i = 0; i < t.length(); i++) {
            ++charArray[t.charAt(i)];
        }

        int left = 0;

        for (int i = 0; i < s.length(); ++i) {
//            if (mp.containsKey(s.charAt(i))) {
//                left = i;
//                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
//                break;
//            }
            if(charArray[s.charAt(i)] > 0){
                left = i;
                --charArray[s.charAt(i)];
                break;
            }
        }


        if(isValid(charArray)){
            return s.substring(left, left+1);
        }

        int right = left + 1;


        char ch;
        while (right < s.length()) {
            ch = s.charAt(right);
//            if (mp.containsKey(ch)) {
//                mp.put(ch, mp.get(ch) - 1);
//            }
            --charArray[ch];
            ++right;
            if (isValid(charArray)) {
                break;
            }
        }

        if (!isValid(charArray)) {
            return "";
        }

        int ans = right - left;
        String ansStr = s.substring(left, right);


        while (right <= s.length()) {
            if(isValid(charArray)){
                ch = s.charAt(left);
//                if (mp.containsKey(ch)) {
//                    mp.put(ch, mp.get(ch) + 1);
//                }
                ++charArray[ch];
                ++left;
            } else {
                if(right == s.length()){
                    break;
                }
                ch = s.charAt(right);
//                if (mp.containsKey(ch)) {
//                    mp.put(ch, mp.get(ch) - 1);
//                }
                --charArray[ch];
                ++right;
            }

            if(isValid(charArray) && right - left < ans){
                ans = right - left;
                ansStr = s.substring(left, right);
            }
        }
        

        return ansStr;
    }

    public static void main(String[] args) {
        _76MinimumWindowSubstring ob = new _76MinimumWindowSubstring();

       System.out.println(ob.minWindow("ADOBECODEBANC", "ABC"));

//        System.out.println(ob.minWindow("ab", "a"));

    }
}

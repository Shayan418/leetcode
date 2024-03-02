import java.util.HashMap;

class _76MinimumWindowSubstring {

    public boolean isValid(HashMap<Character, Integer> mp) {
        return mp.values().stream().allMatch(value -> value <= 0);
    }

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> mp = new HashMap<>();

        for (Character ch : t.toCharArray()) {
            if (!mp.containsKey(ch)) {
                mp.put(ch, 0);
            }
            mp.put(ch, mp.get(ch) + 1);
        }

        int left = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (mp.containsKey(s.charAt(i))) {
                left = i;
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                break;
            }
        }

        if(isValid(mp)){
            return s.substring(left, left+1);
        }

        int right = left + 1;

        

        while (right < s.length()) {
            Character ch = s.charAt(right);
            if (mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) - 1);
            }
            ++right;
            if (isValid(mp)) {
                break;
            }
        }

        if (!isValid(mp)) {
            return "";
        }

        int ans = right - left;
        String ansStr = s.substring(left, right);

        while (right <= s.length()) {
            if(isValid(mp)){
                Character ch = s.charAt(left);
                if (mp.containsKey(ch)) {
                    mp.put(ch, mp.get(ch) + 1);
                }
                ++left;
            } else {
                if(right == s.length()){
                    break;
                }
                Character ch = s.charAt(right);
                if (mp.containsKey(ch)) {
                    mp.put(ch, mp.get(ch) - 1);
                }
                ++right;
            }

            if(isValid(mp) && right - left < ans){
                ans = right - left;
                ansStr = s.substring(left, right);
            }
        }
        

        return ansStr;
    }

    public static void main(String[] args) {
        _76MinimumWindowSubstring ob = new _76MinimumWindowSubstring();

//       System.out.println(ob.minWindow("ADOBECODEBANC", "ABC"));

        System.out.println(ob.minWindow("ab", "a"));

    }
}

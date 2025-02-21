import java.util.HashSet;
import java.util.Set;

public class _1593SplitaStringIntotheMaxNumberofUniqueSubstrings {
    int ans;
    _1593SplitaStringIntotheMaxNumberofUniqueSubstrings(){
        ans = 0;
    }
    public int maxUniqueSplit(String s) {

        Set<String> set = new HashSet<>();
        helper(0, s, set);
        return ans;
    }

    public void helper(int idx, String s, Set set){
        if(idx == s.length()){
            ans = Math.max(ans, set.size());
        }

        for(int i = idx+1; i <= s.length(); ++i){
            if(set.add(s.substring(idx, i))){
                helper(idx + (i-idx), s, set);
                set.remove(s.substring(idx, i));
            }
        }
    }

    public static void main(String[] args) {
        _1593SplitaStringIntotheMaxNumberofUniqueSubstrings ob = new _1593SplitaStringIntotheMaxNumberofUniqueSubstrings();

//        System.out.println(ob.maxUniqueSplit("ababccc"));
        System.out.println(ob.maxUniqueSplit("aba"));

    }
}

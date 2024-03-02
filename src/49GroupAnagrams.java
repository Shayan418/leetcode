import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class _49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> mp = new HashMap<>();

        for(String str: strs){
            char[] charr = str.toCharArray();
            Arrays.sort(charr);
            String sorted = new String(charr);
            if(!mp.containsKey(sorted)){
                mp.put(sorted, new ArrayList<String>());
            }
            mp.get(sorted).add(str);
        }

        List<List<String>> ans = new ArrayList<>();

        for(String key: mp.keySet()){
            ans.add(mp.get(key));
        }

        return ans;
    }
}

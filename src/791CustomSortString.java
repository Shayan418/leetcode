import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class _791CustomSortString {
    public static String customSortString(String order, String s) {
        
        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i = 0 ; i < order.length(); ++i){
            mp.put(order.charAt(i), i);
        }

        List<Character> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; --i){
            sb.append(s.charAt(i));
        }

        for(int i = 0 ; i < sb.length(); ++i){
            if(mp.containsKey(sb.charAt(i))){
                arr.add(sb.charAt(i));
                sb.deleteCharAt(i);
                --i;
            }
        }

        Collections.sort(arr, (Character c1, Character c2) -> mp.get(c1) - mp.get(c2));

        for(int i = arr.size() - 1; i >= 0; --i){
            sb.append(arr.get(i));
        }

        sb.reverse();

        return sb.toString();
    }    

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
    }
}

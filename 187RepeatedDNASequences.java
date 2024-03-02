import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class _187RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> st = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for (int i=0; i <= s.length() - 10;i++){
            int j = i + 10;
            String temp = s.substring(i,j);
            if(!st.contains(temp)){
                st.add(temp);
            }else{
                ans.add(temp);
            }
        }

        ArrayList<String> ret = new ArrayList<>();
        for(String eachString : ans)
            ret.add(eachString);


        return ret;
    }

    public static void main(String[] args) {
        _187RepeatedDNASequences ob = new _187RepeatedDNASequences();

        System.out.println(ob.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}

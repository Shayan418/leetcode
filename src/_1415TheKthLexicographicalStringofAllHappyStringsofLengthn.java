import java.util.ArrayList;
import java.util.List;

public class _1415TheKthLexicographicalStringofAllHappyStringsofLengthn {
        public String getHappyString(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        if(helper(' ', sb, k, n, list)){
            return list.get(k-1);
        }

        return "";
    }


    public boolean helper(char prev, StringBuilder sb, int k, int n,List<String> list){
        if(sb.length() > n){
            return false;
        }
        
        
        if(sb.length() == n){
            list.add(sb.toString());
            if(list.size() == k){
                return true;
            }
        }


        if(prev != 'a'){
            sb.append('a');
            if(helper('a', sb, k, n,list)){
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        } 
        if(prev != 'b'){
            sb.append('b');
            if(helper('b', sb, k, n,list)){
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if(prev != 'c'){
            sb.append('c');
            if(helper('c', sb, k, n,list)){
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return false;
    }



    public static void main(String[] args) {
        _1415TheKthLexicographicalStringofAllHappyStringsofLengthn ob = new _1415TheKthLexicographicalStringofAllHappyStringsofLengthn();

        System.out.println(ob.getHappyString(3, 9));
    }
}

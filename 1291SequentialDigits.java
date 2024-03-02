import java.util.ArrayList;
import java.util.List;

class _1291SequentialDigits {

    public StringBuilder nextNumber(StringBuilder sb){
        if(sb.charAt(sb.length() - 1) == '9'){
            int size = sb.length();
            sb.delete(0, size);
            for(int i = 1; i <= size+1; ++i){
                sb.append(Integer.toString(i));
            }

        } else {
            sb.append(sb.charAt(sb.length() - 1) - 47);
            sb.deleteCharAt(0);
        }

        return sb;
    }


    public List<Integer> sequentialDigits(int low, int high) {
        
        StringBuilder sb = new StringBuilder();
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= Integer.toString(low).length(); ++i){
            sb.append(Integer.toString(i));
        }

        while(Integer.parseInt(sb.toString()) < low){
            sb = nextNumber(sb);
        }


        while(sb.length() <= 9 && Integer.parseInt(sb.toString()) < high){
            ans.add(Integer.parseInt(sb.toString()));
            sb = nextNumber(sb);
        }


        return ans;

    }

    public static void main(String[] args) {
        _1291SequentialDigits ob = new _1291SequentialDigits();

        System.out.println(ob.sequentialDigits(999, 1000000000));
    }
}

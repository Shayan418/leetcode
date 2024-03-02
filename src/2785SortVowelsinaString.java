import java.util.ArrayList;
import java.util.Collections;

class _2785SortVowelsinaString {

    public boolean isVowel(char ch) {
        switch (ch) {
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

    public String sortVowels(String s) {
        
        StringBuilder sb = new StringBuilder(s);

        ArrayList<Integer> vowels = new ArrayList<>();

        for(int i=0;i< sb.length(); ++i){
            if(isVowel(sb.charAt(i))){
                vowels.add((int)sb.charAt(i));
            }
        }

        Collections.sort(vowels);

        int idx = 0;
        for(int i=0;i< sb.length() && idx < vowels.size(); ++i){
            if(isVowel(sb.charAt(i))){
                sb.setCharAt(i, (char) (vowels.get(idx)).intValue());
                ++idx;
            }
        }

        return sb.toString();



    }

    public static void main(String[] args) {
        _2785SortVowelsinaString ob = new _2785SortVowelsinaString();

        System.out.println(ob.sortVowels("lEetcOde"));
    }
}

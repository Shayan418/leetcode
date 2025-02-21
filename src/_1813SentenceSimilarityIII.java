import java.util.Objects;

public class _1813SentenceSimilarityIII {
    String getWord(String s, int idx){
        StringBuilder sb = new StringBuilder();
        while (idx < s.length() && s.charAt(idx) != ' ') {
            sb.append(s.charAt(idx));
            ++idx;
        }
        return sb.toString();
    }

    int nextWord(String s, int idx){
        while (idx < s.length() && s.charAt(idx) != ' ') {
            ++idx;
        }
        return idx + 1;
    }

    int previousWord(String s, int idx){
        do {
            --idx;
        } while (idx > 0 && s.charAt(idx - 1) != ' ');
        return idx;
    }

    public boolean areSentencesSimilar(String s1, String s2) {
        int l1, r1, l2, r2;

        l1 = l2 = 0;
        r1 = s1.length() - 1;
        r2 = s2.length() - 1;

        while (r1 > 0 && s1.charAt(r1-1) != ' ') {
            --r1;
        }

        while (r2 > 0 && s2.charAt(r2-1) != ' ') {
            --r2;
        }

        while(l1 < s1.length() && l2 < s2.length() && Objects.equals(getWord(s1, l1), getWord(s2, l2))) {
            l1 = nextWord(s1, l1);
            l2 = nextWord(s2, l2);
        }

        if(l1 != l2){
            return false;
        }

        while(r1 >= 0 && r2 >= 0 && Objects.equals(getWord(s1, r1), getWord(s2, r2))) {
            r1 = previousWord(s1, r1);
            r2 = previousWord(s2, r2);
        }

        if(r1 == -1 || r2 == -1 || l1 >= s1.length() || l2 >= s2.length()){
            return true;
        }

        if(r2 < l2){
            r1 = nextWord(s1, r1);
            return Objects.equals(getWord(s1, r1), getWord(s2, l2));
        }

        if(r1 < l1){
            r2 = nextWord(s2, r2);
            return Objects.equals(getWord(s1, l1), getWord(s2, r2));
        }

        return false;
    }

    public static void main(String[] args) {
        _1813SentenceSimilarityIII obj = new _1813SentenceSimilarityIII();
        System.out.println(obj.areSentencesSimilar("A A AAa", "A AAa"));

    }
}

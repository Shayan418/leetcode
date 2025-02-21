public class _2000ReversePrefixofWord {
    public String reversePrefix(String word, char ch) {
        int i = 0;
        for(; i < word.length(); ++i){
            if(word.charAt(i) == ch)
                break;
        }

        if(i == word.length())
            return word;

        StringBuilder ans = new StringBuilder(word.substring(0, i+1));
        ans.reverse();
        ans.append(word.substring(i+1, word.length()));
        return ans.toString();
    }

    public static void main(String[] args) {
        
    }
}

public class _1957DeleteCharacterstoMakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));


        for(int i = 2; i < s.length(); ++i){
            if(s.charAt(i) != sb.charAt(sb.length()-1) || s.charAt(i) != sb.charAt(sb.length()-2)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        _1957DeleteCharacterstoMakeFancyString ob = new _1957DeleteCharacterstoMakeFancyString();
        System.out.println(ob.makeFancyString("aaabaaa"));
    }
}

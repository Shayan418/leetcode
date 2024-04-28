public class _1249MinimumRemovetoMakeValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        
        int diff = 0;
        StringBuilder sb = new StringBuilder();
        for(Character ch: s.toCharArray()){
            sb.append(ch);
            if(ch.equals('(')){
                ++diff;
            } else if(ch.equals(')')){
                if(diff == 0){
                    sb.deleteCharAt(sb.length() - 1);
                } else{
                    --diff;
                }
            }

        }       

        int idx = sb.length() - 1;
        while (idx >=0 && diff > 0) {
            if(sb.charAt(idx) == '(') {
                sb.deleteCharAt(idx);
                --diff;
            }
            --idx;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
    }
}

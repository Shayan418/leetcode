class _1544MakeTheStringGreat {
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); ++i){
            if(sb.length() == 0){
                sb.append(s.charAt(i));
                continue;
            }

            if((sb.charAt(sb.length() - 1) == s.charAt(i) - 32) || (sb.charAt(sb.length() - 1) == s.charAt(i) + 32)){
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();

    }
    
    public static void main(String[] args) {
        System.out.println(makeGood("abBAcC"));
    }
}

public class _567PermutationinString {
    public boolean isEqual(int[] x, int[] y){
        for(int i = 0; i < x.length; ++i){
            if(x[i] != y[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        int length = s1.length();
        for(int i = 0; i < length; ++i){
            ++ch1[s1.charAt(i) - 97];
            ++ch2[s2.charAt(i) - 97];
        }
        if(isEqual(ch1, ch2)){
            return true;
        }

        for(int i = 1; i < s2.length() - length + 1; ++i){
            --ch2[s2.charAt(i-1) - 97];
            ++ch2[s2.charAt(i+length-1) - 97];
            if(isEqual(ch1, ch2)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        _567PermutationinString obj = new _567PermutationinString();
        System.out.println(obj.checkInclusion("abc", "fffffcba"));
    }
}

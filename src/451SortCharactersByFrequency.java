import java.util.Arrays;

class _451SortCharactersByFrequency {
    public String frequencySort(String s) {

        int[][] arr = new int[128][2];

        for(char ch : s.toCharArray()){
            arr[ch][0] = ch;
            arr[ch][1] += 1;
        }

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; ++i){
            if(arr[i][0] == 0){
                continue;
            }
            char ch = (char) arr[i][0];
            int count = arr[i][1];
            while (count > 0) {
                sb.append(ch);
                --count;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        _451SortCharactersByFrequency ob = new _451SortCharactersByFrequency();
        System.out.println(ob.frequencySort("BBBbbAAaaaaa"));
    }
}

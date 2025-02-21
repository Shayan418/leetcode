import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _632SmallestRangeCoveringElementsfromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] pointer = new int[nums.size()];

        int ansMin = Integer.MAX_VALUE;
         int ansMax = 0;
        int diff = Integer.MAX_VALUE;

//        int[] min_idx = new int[2];
//        int[] max_idx = new int[2];
        int min, max, idxmin = -1, idxmax = -1;
        while (true) {
            min = Integer.MAX_VALUE;
            max = 0;
            for(int i = 0; i < nums.size(); i++) {
                if(nums.get(i).get(pointer[i]) < min){
                    min = nums.get(i).get(pointer[i]);
                    idxmin = i;
                }
                if(nums.get(i).get(pointer[i]) > max){
                    max = nums.get(i).get(pointer[i]);
                    idxmax = i;
                }
            }

            if(max - min < diff){
                diff = max - min;
                ansMin = min;
                ansMax = max;
            }

            int minChosenFromK = idxmin;
            ++pointer[minChosenFromK];

            if(nums.get(minChosenFromK).size() == pointer[minChosenFromK]){
                break;
            }

        }

        return new int[]{ansMin, ansMax};
    }

    public static void main(String[] args) {
        _632SmallestRangeCoveringElementsfromKLists ob = new _632SmallestRangeCoveringElementsfromKLists();
        List<List<Integer>> nums = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(4, 10, 15, 24, 26)),
                        new ArrayList<>(Arrays.asList(0,9,12,20)),
                        new ArrayList<>(Arrays.asList(5,18,22,30))
                ));


        System.out.println(Arrays.toString(ob.smallestRange(nums)));
    }
}

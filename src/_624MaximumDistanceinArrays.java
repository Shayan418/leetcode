import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _624MaximumDistanceinArrays {

    public int maxDistance(List<List<Integer>> arrays) {
        
        return Math.max(helper(arrays.get(0).get(0),Integer.MIN_VALUE,arrays), helper(Integer.MAX_VALUE,arrays.get(0).get(arrays.get(0).size() - 1),arrays));
    }

    int helper(long currMin, long currMax, List<List<Integer>> arrays){
        for(int i = 1; i < arrays.size(); ++i){
            int min = arrays.get(i).get(0);
            int max = arrays.get(i).get(arrays.get(i).size() - 1);

            if(arrays.get(i).size() == 1){
                if(min < currMin){
                    currMin = min;
                } else if(max > currMax){
                    currMax = max;
                }
            } else if (min < currMin || max > currMax){
                if(currMax - min > max - currMin){
                    currMin = min;
                } else {
                    currMax = max;
                }
            }
        }

        return (int)(currMax - currMin);
    }

    public static void main(String[] args) {
        _624MaximumDistanceinArrays ob = new _624MaximumDistanceinArrays();

        // List<List<Integer>> arr = new ArrayList<>(Arrays.asList(
        //     new ArrayList<>(Arrays.asList(1,2,3)),
        //     new ArrayList<>(Arrays.asList(4,5)),
        //     new ArrayList<>(Arrays.asList(1,2,3)) 
        // ));
        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(1,5)),
            new ArrayList<>(Arrays.asList(3,4))
        ));

        System.out.println(ob.maxDistance(arr));
    }
}
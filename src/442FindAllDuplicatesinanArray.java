import java.util.ArrayList;
import java.util.List;

class _442FindAllDuplicatesinanArray {
    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            int n = Math.abs(nums[i]) - 1;

            if (nums[n] < 0) {
                res.add(n + 1);
            }

            nums[n] = nums[n] * -1;

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
        System.out.println(findDuplicates(new int[] { 2, 2 }));
    }

}

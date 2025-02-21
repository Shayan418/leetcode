import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _2501LongestSquareStreakinanArray {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        int curr = 0;
        int currntNumber = 0;
        for (int num : nums) {
            curr = 1;
            currntNumber = num;
            while (currntNumber < 46341 && set.contains(currntNumber * currntNumber)) {
                currntNumber = currntNumber * currntNumber;
                ++curr;
            }
            ans = Math.max(ans, curr);
        }
        return ans == 1 ? -1 : ans;
    }

    public static void main(String[] args) {
        _2501LongestSquareStreakinanArray ob = new _2501LongestSquareStreakinanArray();
        int[] nums = new int[] { 4,3,6,16,8,2 };

        System.out.println(ob.longestSquareStreak(nums));
    }
}

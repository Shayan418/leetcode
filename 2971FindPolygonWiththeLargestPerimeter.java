import java.util.Arrays;

class _2971FindPolygonWiththeLargestPerimeter {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long ans = -1L;
        long curr = (1L * nums[0]);
        int count = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (curr <= nums[i] && i >= nums.length - 1) {
                break;
            }
            if (curr <= nums[i] && count >= 3) {
                ans = curr;
            } 
            curr += nums[i];
            ++count;
            if(i == nums.length - 1){
                ans = curr;
            }
        }

        if (count < 3) {
            return -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        _2971FindPolygonWiththeLargestPerimeter ob = new _2971FindPolygonWiththeLargestPerimeter();

        System.out.println(ob.largestPerimeter(new int[] { 50,12,2,3,4}));
    }
}

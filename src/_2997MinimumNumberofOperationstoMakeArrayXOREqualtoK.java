public class _2997MinimumNumberofOperationstoMakeArrayXOREqualtoK {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int i = 1; i <= 32; ++i) {
            int temp = 0;
            for (int j = 0; j < nums.length; ++j) {
                temp = temp ^ (isBitSet(nums[j]));
                nums[j] = nums[j] >>> 1;
            }

            if (temp != isBitSet(k)){
                ++ans;
            }
            k = k >>> 1;
        }

        return ans;
    }

    public int isBitSet(int n) {
        return ((n & 1) == 1) ? 1 : 0;
    }

    public static void main(String[] args) {
        _2997MinimumNumberofOperationstoMakeArrayXOREqualtoK ob = new _2997MinimumNumberofOperationstoMakeArrayXOREqualtoK();
        System.out.println(ob.minOperations(new int[] { 2, 1, 3, 4 }, 1));

    }
}

class _41FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; ++i) {

            while (nums[i] > 0 && nums[i] <= len && nums[i] != i + 1) {
                int target_idx = nums[i] - 1;
                int temp = nums[target_idx];
                if(temp == nums[i]){
                    break;
                }
                nums[target_idx] = target_idx + 1;
                nums[i] = temp;
            }
        }

        for (int i = 0; i < len; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len+1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] { 1, 1 }));
        System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
    }
}

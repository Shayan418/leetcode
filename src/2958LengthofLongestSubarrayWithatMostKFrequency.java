import java.util.HashMap;

class _2958LengthofLongestSubarrayWithatMostKFrequency {

    public static int maxSubarrayLength(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int ans = 0;
        int max = 0;
        int num = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        while (r < nums.length) {
            mp.computeIfAbsent(nums[r], key -> 0);
            mp.put(nums[r], mp.get(nums[r]) + 1);

            if (mp.get(nums[r]) > max) {
                max = mp.get(nums[r]);
                num = nums[r];
            }
            ++r;

            while (max > k) {
                if (nums[l] == num) {
                    --max;
                }
                if(mp.get(nums[l]) == 1){
                    mp.remove(nums[l]);
                } else {
                    mp.put(nums[l], mp.get(nums[l]) - 1);
                }
                ++l;
            }

            ans = Math.max(ans, r - l);

        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[] { 1,2,1,2,3 }, 2));
        System.out.println(maxSubarrayLength(new int[] { 1, 2, 3, 1, 2, 3, 1, 2 }, 2));
    }

}

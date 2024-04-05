import java.util.HashMap;

class _992SubarrayswithKDifferentIntegers {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);

    }

    public static int helper(int[] nums, int k){
        int ans = 0;

        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        while (r < nums.length) {
            mp.computeIfAbsent(nums[r], key -> 0);
            mp.put(nums[r], mp.get(nums[r]) + 1);


            while(mp.size() > k && l <= r){
                if(mp.get(nums[l]) == 1){
                    mp.remove(nums[l]);
                } else {
                    mp.put(nums[l], mp.get(nums[l]) - 1);
                }
                ++l;
            }
            ans += r - l + 1;
            ++r;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
    }
}

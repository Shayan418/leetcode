class _713SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int ans = 0;

        long prod = 1L;

        while (r < nums.length) {
            prod = prod * nums[r];
            
            while(prod >= k && l <= r){
                prod = prod / nums[l];
                ++l;
            }
            ans += r - l + 1; 
            ++r;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] { 2,2,2,2 }, 100));
        System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
        System.out.println(numSubarrayProductLessThanK(new int[] { 10,2,2,5,4,4,4,3,7,7 }, 289));
    }

}

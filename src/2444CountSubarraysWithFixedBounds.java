class _2444CountSubarraysWithFixedBounds {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        
        int mn = -1, mx = -1;
        int l = 0, r = 0;
        long ans = 0L;

        while (r < nums.length) {
            if(nums[r] < minK || nums[r] > maxK ){
                l = r + 1;
                ++r;
                continue;
            }

            if(nums[r] == minK){
                mn = r;
            }
            if(nums[r] == maxK){
                mx = r;
            }

            if(Math.min(mn, mx) - l >= 0){
                ans += Math.min(mn, mx) - l + 1;
            }
            
            ++r;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,5,2,1,7,5}, 1, 5));
        System.out.println(countSubarrays(new int[]{1,1,1,1}, 1, 1));
    }
}

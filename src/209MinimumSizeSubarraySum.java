class _209MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;

        int sum = nums[0];
        int ans = Integer.MAX_VALUE;

        while(r < nums.length){
            if(sum < target){
                if(r == nums.length-1){
                    break;
                }
                ++r;
                sum += nums[r];
            }

            if(sum >= target){
                ans = Math.min(ans, r-l+1);
                sum -= nums[l];
                ++l;
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        _209MinimumSizeSubarraySum ob = new _209MinimumSizeSubarraySum();

        System.out.println(ob.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

}








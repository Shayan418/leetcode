class _977SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {

        int neg = 0;
        int pos = 0;

        while (nums[pos] < 0) {
            ++pos;
        }
        neg = pos - 1;

        int[] ans = new int[nums.length];
        int i = 0;
        for ( ; i < ans.length && pos < nums.length && neg >= 0; ++i) {
            if (nums[pos] < Math.abs(nums[neg])) {
                ans[i] = nums[pos] * nums[pos];
                ++pos;
            } else {
                ans[i] = nums[neg] * nums[neg];
                --neg;
            }
        }

        while(neg >= 0){
            ans[i] = nums[neg] * nums[neg];
            --neg; ++i;
        }

        while(pos < nums.length){
            ans[i] = nums[pos] * nums[pos];
            ++pos; ++i;
        }

        return ans;

    }

    public static void main(String[] args) {
        _977SquaresofaSortedArray ob = new _977SquaresofaSortedArray();

        int[] ans =  ob.sortedSquares(new int[] { -4, -1, 0, 3, 10 });

        for(int n : ans){
            System.err.println(n);
        }

    }
}

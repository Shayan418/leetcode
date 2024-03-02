import java.util.Arrays;

class _1887ReductionOperationstoMaketheArrayElementsEqual {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;

        int l = nums.length - 1;
        int min = nums[0];

        if(nums[l] == min){
            return 0;
        }

        while(l > 0){
            if(nums[l] == min){
                break;
            }
            int count = ans + 1;
            while(l >= 1 && nums[l] == nums[l-1]){
                --l;
                ++count;
            }
            --l;
            ans += count;
        }

        return ans;

    }
    
    public static void main(String[] args) {
        _1887ReductionOperationstoMaketheArrayElementsEqual ob = new _1887ReductionOperationstoMaketheArrayElementsEqual();

        System.out.println(ob.reductionOperations(new int[]{7,9,10,8,6,4,1,5,2,3}));
    }
}

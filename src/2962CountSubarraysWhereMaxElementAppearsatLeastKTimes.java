import java.util.Arrays;

class _2962CountSubarraysWhereMaxElementAppearsatLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        
        int max = Arrays.stream(nums).max().getAsInt();
        
        int ans = 0;

        int l = 0;
        int r = 0;
        int count = 0;

        while (r < nums.length) {
            count = nums[r] == max ? count + 1 : count;
            
            while(count >= k && l <= r){
                count = nums[l] == max ? count - 1 : count;
                ++l;
            }
            ans += r - l + 1;
            ++r;
        }

        int totalSubarrays = (nums.length * (nums.length + 1))/2;

        return totalSubarrays - ans;
    }   
    
    public static void main(String[] args) {
        
    }
}

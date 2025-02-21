import java.util.PriorityQueue;

public class _1438LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> min = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        PriorityQueue<int[]> max = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        int left = 0;
        int right = 0;
        int ans = 0;
        
        while (left <= right && right < nums.length) {
            max.add(new int[]{right, nums[right]});
            min.add(new int[]{right, nums[right]});

            while (Math.abs(min.peek()[1] - max.peek()[1]) > limit) {
                
                left = Math.min(min.peek()[0], max.peek()[0]) + 1;

                while(max.peek()[0] < left){
                    max.poll();
                }

                while(min.peek()[0] < left){
                    min.poll();    
                }
            }

            ans = Math.max(ans, right - left + 1);
            ++right;
        }

        return ans;
    }




    public static void main(String[] args) {
        _1438LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit ob = new _1438LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit();
        System.out.println(ob.longestSubarray(new int[]{1,5,6,7,8,10,6,5,6}, 4));
        System.out.println(ob.longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
        System.out.println(ob.longestSubarray(new int[]{10,1,2,4,7,2}, 5));
        System.out.println(ob.longestSubarray(new int[]{8,2,4,7}, 4));
    }

}

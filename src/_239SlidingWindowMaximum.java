import java.util.Deque;
import java.util.LinkedList;

public class _239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; ++i) {

            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.pollLast();
            }

            while (!q.isEmpty() && q.peekFirst() < nums[i]) {
                q.pollFirst();
            }

            q.addFirst(nums[i]);
        }
        ans[0] = q.peekLast();


        for(int i = k; i < nums.length; ++i){
            int left = i - k;

            if(q.getLast().equals(nums[left])){
                q.pollLast();
            }
            
            while (!q.isEmpty() && q.peekLast() < nums[i]) {
                q.pollLast();
            }

            while (!q.isEmpty() && q.peekFirst() < nums[i]) {
                q.pollFirst();
            }

            q.addFirst(nums[i]);

            ans[i - k + 1] = q.peekLast();
        }
        
        return ans;
    }

    public static void main(String[] args) {
        _239SlidingWindowMaximum ob = new _239SlidingWindowMaximum();

        for(int n :ob.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)){
            System.out.print(n + " ");
        }
        System.out.println();
        for(int n :ob.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)){
            System.out.print(n + " ");
        }
    }

}

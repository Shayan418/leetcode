import java.util.Collections;
import java.util.PriorityQueue;

class _621TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char ch : tasks) {
            ++arr[ch - 'A'];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr) {
            if (x > 0) {
                pq.add(x);
            }
        }

        int ans = 0;

        while (!pq.isEmpty()) {
            PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
            int curr = 0;
            while (!pq.isEmpty()) {
                int t = pq.poll();
                --t;
                ++curr;
                if (t > 0) {
                    temp.add(t);
                }
                if (curr == n + 1) {
                    while (!pq.isEmpty()) {
                        temp.add(pq.poll());
                    }
                    break;
                }
            }
            pq = temp;
            if (curr <= n && !pq.isEmpty()) {
                curr = curr + ((n + 1) - curr);
            }
            ans += curr;
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E' }, 2));
        System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 1));
        System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 3));
    }
}

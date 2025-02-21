import java.util.Arrays;
import java.util.PriorityQueue;

public class _2406DivideIntervalsIntoMinimumNumberofGroups {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if(!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        _2406DivideIntervalsIntoMinimumNumberofGroups ob = new _2406DivideIntervalsIntoMinimumNumberofGroups();
        System.out.println(ob.minGroups(new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}}));
    }

}

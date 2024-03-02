import java.util.ArrayList;
import java.util.PriorityQueue;

class _2976MinimumCosttoConvertStringI {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        ArrayList<ArrayList<long[]>> gp = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            gp.add(new ArrayList<>());
        }

        for (int i = 0; i < cost.length; ++i) {
            gp.get(original[i] - 'a').add(new long[] { changed[i] - 'a', cost[i] });
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((long[] n1, long[] n2) -> {
            return (n1[1] > n2[1]) ? 1 : -1;
        });

        ArrayList<ArrayList<Long>> ansMat = new ArrayList<>();

        for (int i = 0; i < 26; ++i) {
            ArrayList<Long> currans = new ArrayList<>();
            for (int j = 0; j < 26; ++j) {
                currans.add(Long.MAX_VALUE);
            }

            pq.add(new long[] { i, 0 });

            while (!pq.isEmpty()) {
                long[] temp = pq.poll();

                if (temp[1] > currans.get((int) temp[0])) {
                    continue;
                }

                currans.set((int) temp[0], temp[1] * 1L);

                for (long[] Node : gp.get((int) temp[0])) {
                    if (currans.get((int) Node[0]) > Node[1] + temp[1]) {
                        pq.add(new long[] { Node[0], Node[1] + temp[1] });
                    }
                }
            }

            ansMat.add(currans);
        }

        long ans = 0;
        for (int i = 0; i < source.length(); ++i) {
            long temp = ansMat.get(source.charAt(i) - 'a').get(target.charAt(i) - 'a');
            if (temp == Integer.MAX_VALUE) {
                return -1;
            }
            ans += temp;
        }

        return ans;

    }

    public static void main(String[] args) {
        _2976MinimumCosttoConvertStringI ob = new _2976MinimumCosttoConvertStringI();

        System.out.println(ob.minimumCost("abcd", "acbe", new char[] { 'a', 'b', 'c', 'c', 'e', 'd' },
                new char[] { 'b', 'c', 'b', 'e', 'b', 'e' }, new int[] { 2, 5, 5, 1, 2, 20 }));
    }
}

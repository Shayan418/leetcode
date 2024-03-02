import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class _2092FindAllPeopleWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (int[] x, int[] y) -> x[2] - y[2]);

        Map<Integer, ArrayList<int[]>> mp = new TreeMap<>();
        for (int[] meet : meetings) {
            int time = meet[2];
            mp.computeIfAbsent(time, k -> new ArrayList<int[]>()).add(new int[] { meet[0], meet[1] });
        }

        boolean[] doesknowsecret = new boolean[n];
        doesknowsecret[0] = doesknowsecret[firstPerson] = true;

        for (Integer t : mp.keySet()) {
            ArrayList<int[]> meets = mp.get(t);

            HashSet<Integer> temp = new HashSet<>();
            HashMap<Integer, ArrayList<Integer>> meetgp = new HashMap<>();
            for (int[] meet : meets) {
                meetgp.computeIfAbsent(meet[0], k -> new ArrayList<Integer>()).add(meet[1]);
                meetgp.computeIfAbsent(meet[1], k -> new ArrayList<Integer>()).add(meet[0]);
                if (doesknowsecret[meet[0]]) {
                    temp.add(meet[0]);
                }
                if (doesknowsecret[meet[1]]) {
                    temp.add(meet[1]);
                }
            }

            Queue<Integer> q = new LinkedList<>(temp);
            while (!q.isEmpty()) {
                int size = q.size();
                for (; size > 0; --size) {
                    int polled = q.poll();
                    for (Integer met : meetgp.get(polled)) {
                        if (!doesknowsecret[met]) {
                            q.add(met);
                            doesknowsecret[met] = true;
                        }
                    }
                }
            }
        }

        List<Integer> ans;
        ans = IntStream.range(0, doesknowsecret.length)
                .filter(i -> doesknowsecret[i])
                .boxed()
                .collect(Collectors.toList());

        return ans;
    }

    public static void main(String[] args) {
        _2092FindAllPeopleWithSecret ob = new _2092FindAllPeopleWithSecret();
        System.out.println(ob.findAllPeople(6, new int[][] { { 1, 2, 5 }, { 2, 3, 8 }, { 1, 5, 10 } }, 1));
    }
}

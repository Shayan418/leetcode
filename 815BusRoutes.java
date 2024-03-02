import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class _815BusRoutes {
    ArrayList<ArrayList<Integer>> gp;

    _815BusRoutes() {
        gp = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= 500; ++i) {
            gp.add(new ArrayList<Integer>());
        }
    }

    public boolean hasCommon(int[] n1, int[] n2) {
        int i = 0;
        int j = 0;

        while (i < n1.length && j < n2.length) {
            if (n1[i] == n2[j]) {
                return true;
            }

            if (n1[i] <= n2[j]) {
                ++i;
            } else {
                ++j;
            }
        }
        return false;
    }

    public boolean hasSource(int[] r, int s) {
        // binarysearch
        int l = 0;
        int h = r.length - 1;
        int mid = l + ((h - l) / 2);

        while (l <= h) {
            mid = l + ((h - l) / 2);
            if (r[mid] == s) {
                return true;
            }

            if (r[mid] > s) {
                h = h - 1;
            } else {
                l = l + 1;
            }

        }
        return false;
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return -1;
        }

        for (int i = 0; i < routes.length; ++i) {
            Arrays.sort(routes[i]);
        }

        int sr = -1;

        for (int i = 0; i < routes.length; ++i) {
            for (int j = i + 1; j < routes.length; ++j) {
                if (hasCommon(routes[i], routes[j])) {
                    gp.get(i).add(j);
                    gp.get(j).add(i);
                }

                if (sr == -1 && hasSource(routes[i], source)) {
                    sr = i;
                }
            }
        }

        if (sr == -1 && hasSource(routes[routes.length -1], source)) {
            sr = routes.length-1;
        }
        if(sr == -1){
            return -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < gp.get(sr).size(); ++i) {
            q.add(gp.get(sr).get(i));
        }

        int ans = 0;
        boolean reached = false;

        boolean[] visited = new boolean[501];

        while (!q.isEmpty() && !reached) {
            int s = q.size();
            ++ans;

            for (int i = 0; i < s; ++i) {
                int curr = q.poll();
                visited[curr] = true;

                if (hasSource(routes[curr], target)) {
                    reached = true;
                    break;
                }

                for (int n : gp.get(curr)) {
                    if (!visited[n]) {
                        q.add(n);
                    }
                }

            }

        }

        if (reached) {
            return ans;
        }

        return -1;
    }

    public static void main(String[] args) {
        _815BusRoutes ob = new _815BusRoutes();

        // int[][] routes = new int[][] {
        // { 1, 2, 7 },
        // { 3, 6, 7 },
        // { 9, 4, 6 }
        // };

        int[][] routes = new int[][] {
                { 2 },
                { 2, 8 }
        };

        System.out.println(ob.numBusesToDestination(routes, 8, 2));
    }
}

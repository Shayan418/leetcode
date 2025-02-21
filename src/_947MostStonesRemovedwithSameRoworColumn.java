import java.util.*;

public class _947MostStonesRemovedwithSameRoworColumn {
    public int removeStones(int[][] stones) {
        Arrays.sort(stones, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            }
            return x[0] - y[0];
        });

        boolean[][] gp = new boolean[1001][1001];

        for (int[] stone : stones) {
            gp[stone[0]][stone[1]] = true;
        }

        boolean[][] visited = new boolean[1000][1000];
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int[] stone : stones) {
            if (!visited[stone[0]][stone[1]]) {
                queue.add(stone);
            }
            int stoneInCluster = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (visited[cur[0]][cur[1]]) {
                    continue;
                }
                ++stoneInCluster;
                visited[cur[0]][cur[1]] = true;
                boolean flag = false;
                for (int i = 0; i < 1001; ++i) {
                    if (gp[cur[0]][i] && !visited[cur[0]][i]) {
                        queue.add(new int[]{cur[0], i});
                        flag = true;
                    }

                    if (gp[i][cur[1]] && !visited[i][cur[1]]) {
                        queue.add(new int[]{i, cur[1]});
                        flag = true;
                    }
                }
            }
            if (stoneInCluster != 0) {
                ans = ans + (stoneInCluster - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _947MostStonesRemovedwithSameRoworColumn ob = new _947MostStonesRemovedwithSameRoworColumn();

        System.out.println(ob.removeStones(new int[][]{{0, 1}, {0, 2}, {4, 3}, {2, 4}, {0, 3}, {1, 1}}));
        System.out.println(ob.removeStones(new int[][]{{3, 2}, {3, 1}, {4, 4}, {1, 1}, {0, 2}, {4, 0}}));
        System.out.println(ob.removeStones(new int[][]{{3, 2}, {0, 0}, {3, 3}, {2, 1}, {2, 3}, {2, 2}, {0, 2}}));
        System.out.println(ob.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
    }
}

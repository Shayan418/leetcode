import java.util.ArrayList;

public class _834SumofDistancesinTree {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[][] aux = new int[n][2];
        boolean[] visited = new boolean[n];
        initialize(0, aux, adj, visited);

        visited = new boolean[n];

        int[] ans = new int[n];
        ans[0] = aux[0][1];

        visited[0] = true;
        int temp_0 = aux[0][0];
        int temp_1 = aux[0][1];
        for (int i = 0; i < adj.get(0).size(); ++i) {
            int target = adj.get(0).get(i);

            aux[0][0] = temp_0 - aux[target][0];
            aux[0][1] = temp_1 - (aux[target][0] + aux[target][1]);
            helper(target, 0, ans, aux, adj, visited);
        }

        return ans;
    }

    public void helper(int n, int p, int ans[], int[][] aux, ArrayList<ArrayList<Integer>> edges, boolean[] visited) {

        visited[n] = true;

        aux[n][0] = aux[n][0] + aux[p][0];
        aux[n][1] = aux[n][1] + aux[p][0] + aux[p][1];
        ans[n] = aux[n][1];

        int temp_0 = aux[n][0];
        int temp_1 = aux[n][1];

        for (int i = 0; i < edges.get(n).size(); ++i) {
            int target = edges.get(n).get(i);
            if (!visited[target]) {

                aux[n][0] = temp_0 - aux[target][0];
                aux[n][1] = temp_1 - (aux[target][0] + aux[target][1]);
                helper(target, n, ans, aux, edges, visited);
            }

        }

    }

    public void initialize(int n, int[][] aux, ArrayList<ArrayList<Integer>> edges, boolean[] visited) {

        visited[n] = true;

        boolean leaf = true;
        for (int i = 0; i < edges.get(n).size(); ++i) {
            if (!visited[edges.get(n).get(i)]) {
                leaf = true;
                initialize(edges.get(n).get(i), aux, edges, visited);
            }
        }

        if (leaf) {
            aux[n][0] = 1;
            aux[n][1] = 0;
        }
        aux[n][0] = 1;
        for (int i = 0; i < edges.get(n).size(); ++i) {
            aux[n][0] += aux[edges.get(n).get(i)][0];
            aux[n][1] += aux[edges.get(n).get(i)][0] + aux[edges.get(n).get(i)][1];
        }

    }

    public static void main(String[] args) {
        int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
        _834SumofDistancesinTree ob = new _834SumofDistancesinTree();

        int[] ans = ob.sumOfDistancesInTree(6, edges);

        for (int n : ans) {
            System.out.print(n + " ");
        }
    }
}

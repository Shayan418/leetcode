import java.util.ArrayList;

public class _1971FindifPathExistsinGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        helper(source, adj, visited);
        return visited[destination];
    }

    public void helper(int n, ArrayList<ArrayList<Integer>> edges, boolean[] visited) {
        visited[n] = true;

        for (int i = 0; i < edges.get(n).size(); ++i) {
            if (!visited[edges.get(n).get(i)]) {
                helper(edges.get(n).get(i), edges, visited);
            }
        }
    }

    public static void main(String[] args) {
        _1971FindifPathExistsinGraph ob = new _1971FindifPathExistsinGraph();

        System.out.println(ob.validPath(6, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } }, 0, 5));
        //System.out.println(ob.validPath(6, new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5} }, 0, 3));
    }
}

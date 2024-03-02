import java.util.Arrays;
import java.util.HashSet;

class _2975MaximumSquareAreabyRemovingFencesFromaField {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        Arrays.sort(hFences);
        Arrays.sort(vFences);

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < hFences.length; ++i) {
            for (int j = i + 1; j < hFences.length; ++j) {
                hs.add(hFences[j] - hFences[i]);
            }
        }

        for (int i = 0; i < hFences.length; ++i) {
            hs.add(hFences[i] - 1);
        }

        for (int i = 0; i < hFences.length; ++i) {
            hs.add(m - hFences[i]);
        }

        hs.add(m - 1);

        int ans = -1;
        for (int i = 0; i < vFences.length; ++i) {
            for (int j = i + 1; j < vFences.length; ++j) {
                if (hs.contains(vFences[j] - vFences[i])) {
                    ans = Math.max(ans, vFences[j] - vFences[i]);
                }
            }
        }

        for (int i = 0; i < vFences.length; ++i) {
            if (hs.contains(vFences[i] - 1)) {
                ans = Math.max(ans, vFences[i] - 1);
            }
        }

        for (int i = 0; i < vFences.length; ++i) {
            if (hs.contains(n - vFences[i])) {
                ans = Math.max(ans, n - vFences[i]);
            }
        }

        if (hs.contains(n - 1)) {
            ans = Math.max(ans, n - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        _2975MaximumSquareAreabyRemovingFencesFromaField ob = new _2975MaximumSquareAreabyRemovingFencesFromaField();
        System.out.println(ob.maximizeSquareArea(4, 3, new int[] { 2, 3 }, new int[] { 2 }));
        System.out.println(ob.maximizeSquareArea(6, 7, new int[] { 2 }, new int[] { 4 }));

    }
}

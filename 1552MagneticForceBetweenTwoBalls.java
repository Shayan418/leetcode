class _1552MagneticForceBetweenTwoBalls {
    public int isPossible(int[] position, int diff) {

        int prev = position[0];
        int count = 1;
        for (int i = 1; i < position.length; ++i) {
            if (Math.abs(prev - position[i]) >= diff) {
                prev = position[i];
                ++count;
            }
        }
        return count;
    }

    public int maxDistance(int[] position, int m) {

        int lo = 1;
        int hi = 0;
        for (int n : position) {
            hi = Math.max(hi, n - 1);
        }
        int mid = lo + (hi - lo) / 2;
        int ans = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            // System.out.println(mid);
            int count = isPossible(position, mid);
            if (count >= m) {
                ans = Math.max(ans, mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _1552MagneticForceBetweenTwoBalls ob = new _1552MagneticForceBetweenTwoBalls();
        //System.out.println(ob.maxDistance(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 4));
        System.out.println(ob.maxDistance(new int[] { 5,4,3,2,1,1000000000 }, 2));

    }
}

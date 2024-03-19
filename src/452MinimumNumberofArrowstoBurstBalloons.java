import java.util.Arrays;

class _452MinimumNumberofArrowstoBurstBalloons {
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }

        Arrays.sort(points, (int[] x, int[] y) -> {
            if (x[0] != y[0]) {
                long xl = x[0] * 1L;
                long yl = y[0] * 1L;
                return (xl - yl) > 0 ? 1 : -1;
            }
            long xl = x[1] * 1L;
            long yl = y[1] * 1L;
            return (xl - yl) > 0 ? 1 : -1;
        });


        int ans = 1;
        int left = points[0][1];

        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] > left) {
                ++ans;
                left = points[i][1];
            }
            left = Math.min(left, points[i][1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(findMinArrowShots(new int[][] { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } }));
        // System.out.println(findMinArrowShots(new int[][]{{-1,1},{0,1},{2,3},{1,2}}));
        // System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}}));
    }
}

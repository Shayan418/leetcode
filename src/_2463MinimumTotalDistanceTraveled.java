import java.util.*;

public class _2463MinimumTotalDistanceTraveled {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        List<Integer> flatFactory = new ArrayList<>();

        for(int i = 0; i < factory.length; ++i){
            for(int j = 0; j < factory[i][1]; ++j){
                flatFactory.add(factory[i][0]);
            }
        }

        Collections.sort(robot);
        Collections.sort(flatFactory);


        long[][] dp = new long[robot.size()][flatFactory.size()];
        for (long[] row : dp) Arrays.fill(row, -1);

        // for(int i = robot.size(); i >=0; --i){
        //     for(int j = factory.size(); j >=0; --j){
        //     }
        // }

        return helper(0,0, robot, flatFactory, dp);
    }


    public long helper(int r, int f, List<Integer> robot, List<Integer> flatFactory, long[][] dp){
        if(r == robot.size()){
            return 0;
        }
        
        if(f == flatFactory.size()){
            return (long) 1e12;
        }


        if(dp[r][f] != -1)
            return dp[r][f];

        long take = Math.abs(robot.get(r) - flatFactory.get(f)) + helper(r+1, f+1, robot, flatFactory, dp);

        long skip =  helper(r, f+1, robot, flatFactory, dp);
        dp[r][f] = Math.min(take, skip);
        return dp[r][f];
    }


    public static void main(String[] args) {
        _2463MinimumTotalDistanceTraveled obj = new _2463MinimumTotalDistanceTraveled();
        List<Integer> temp = new ArrayList<>(Arrays.asList(0,4,6));
        int[][] a = new int[][]{{2,2},{6,2}};
//        long ans = obj.minimumTotalDistance(temp, a);
        long ans = obj.minimumTotalDistance(Arrays.asList(1,-1), new int[][]{{-2,1},{2,1}});

        System.out.println(ans);

    }

}

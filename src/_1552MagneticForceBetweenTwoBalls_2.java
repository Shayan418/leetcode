import java.util.Arrays;

public class _1552MagneticForceBetweenTwoBalls_2 {
    int maxBalls(int[] position, int distance){
        int ans = 1;
        int prev = position[0];

        for(int i = 1; i< position.length; ++i){
            if(position[i] - prev >= distance){
                ++ans;
                prev = position[i];
            }
        }
        return ans;
    }
    
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int ans = Integer.MIN_VALUE; 

        int lo = 0;
        int hi = position[position.length - 1];
        int mid = lo + ((hi - lo) / 2);

        while (lo <= hi) {
            mid = lo + ((hi - lo) / 2);

            int currBalls = maxBalls(position, mid);

            if(currBalls >= m){
                lo = mid+1;
                ans = Math.max(ans, mid);
            } else {
                hi = mid-1;
            }

        }

        return ans;
        
    }

    public static void main(String[] args) {
        _1552MagneticForceBetweenTwoBalls_2 ob = new _1552MagneticForceBetweenTwoBalls_2();
        System.out.println(ob.maxDistance(new int[]{94,95,37,30,67,7,5,44,26,55,42,28,97,19,100,74,13,88,18}, 7));
        System.out.println(ob.maxDistance(new int[]{79,74,57,22}, 4));
        System.out.println(ob.maxDistance(new int[]{1,2,3,4,7}, 3));
        System.out.println(ob.maxDistance(new int[]{5,4,3,2,1,1000000000}, 2));
    }
}

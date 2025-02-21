import java.util.HashMap;
import java.util.Map;

public class _2275LargestCombinationWithBitwiseANDGreaterThanZero {
    public static boolean isIthBitSet(int n, int i) {
        // Create a mask with 1 at the i-th position
        int mask = 1 << i;

        // Perform AND operation with the mask
        // If result is non-zero, the bit is set
        return (n & mask) != 0;
    }


    public int largestCombination(int[] candidates) {

        int[] count = new int[32];

        for (int candidate : candidates) {
            for(int i = 0; i < 32; ++i){
                if(isIthBitSet(candidate, i))
                   ++count[i];
            }
        }

        int ans = 0;

        for(int c: count){
            ans = Math.max(ans, c);
        }

        return ans;
    }
}

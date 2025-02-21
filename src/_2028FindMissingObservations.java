import java.util.Arrays;

public class _2028FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ans = new int[n];

        int rollsSum = Arrays.stream(rolls).sum();
        int totalCount  = rolls.length + n;
        //float currMean = (float) rollsSum / totalCount;

        int offset = 0;
//        while (currMean < mean) {
//            ++offset;
//            currMean = (rollsSum + offset) / totalCount;
//        }
        offset = binarySearch(totalCount, mean) - rollsSum;

        if(offset < n){
            return new int[0];
        }

        for (int i = 0; i < ans.length && offset > 0; i++) {
            System.out.println(offset/n);
            int currentMissing = Math.min(6, offset / (n-i));
            ans[i] = currentMissing;
            offset -= currentMissing;
        }

        if (offset > 0 || ans[ans.length-1] == 0) {
            return new int[0];
        }

        return ans;
    }

    public int binarySearch(int totalCount, int mean) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int mid = 0;
        float curr = 0F;
        while (low <= high) {
            mid = (low + high) >>> 1;

            curr = (float) mid / totalCount;
            if (curr == mean){
                return mid;
            }

            else if(curr < mean){
                low = mid + 1;
            }
            else if (curr > mean){
                high = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        _2028FindMissingObservations ob = new _2028FindMissingObservations();
        //int[] ans = ob.missingRolls(new int[]{1,5,6}, 3,4);
        //int[] ans = ob.missingRolls(new int[]{1,2,3,4}, 6,4);
        int[] ans = ob.missingRolls(new int[]{4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3}, 2,53);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

}


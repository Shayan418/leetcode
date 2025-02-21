public class _2285MaximumTotalImportanceofRoads {
    public long maximumImportance(int n, int[][] roads) {
        
        int[] arr = new int[n];

        for(int i = 0 ; i < roads.length; ++i){
            ++arr[roads[i][0]];
            ++arr[roads[i][1]];
        }


        int[] count = new int[n];        
        
        for(int i = 0 ; i < arr.length; ++i){
            ++count[arr[i]];
        }

        long importance = 1L;
        long ans = 0L;
        for(int i = 0; i < count.length; ++i){
            while (count[i] > 0) {
                ans = ans + importance * i;
                ++importance;
                --count[i];
            }
        }

        return ans;
    }
}

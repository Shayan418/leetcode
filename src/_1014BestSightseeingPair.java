public class _1014BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        
        int left = 0;
        int ans = 0;
        int curr = 0;
        
        for(int i = 1; i < values.length; ++i){
            curr = values[left] + values[i] - (i - left);

            ans = Math.max(ans, curr);

            if(values[i] >= values[left] - (i - left)){
                left = i;
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        _1014BestSightseeingPair ob = new _1014BestSightseeingPair();

        System.out.println(ob.maxScoreSightseeingPair(new int[]{7,2,6,6,9,4,3}));
    }

}

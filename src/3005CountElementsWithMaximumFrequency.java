import java.util.HashMap;

class _3005CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        int maxc = 0;

        for(int n: nums){
            mp.computeIfAbsent(n, k -> 0);
            mp.put(n, mp.get(n) + 1);
            maxc = Math.max(maxc, mp.get(n));
        }   

        int ans = 0;

        for(int k: mp.keySet()){
            if(mp.get(k) == maxc){
                ans += maxc;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _3005CountElementsWithMaximumFrequency ob = new _3005CountElementsWithMaximumFrequency();

        System.out.println(ob.maxFrequencyElements(new int[] { 1, 2, 2, 3, 1, 4 }));
    }
}

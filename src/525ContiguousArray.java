import java.util.HashMap;

class _525ContiguousArray {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int sum = 0;
        int ans = 0;
        for(int i= 0; i < nums.length; ++i){
            sum = nums[i] == 1 ? sum+1 : sum -1;
            if(!mp.containsKey(sum)){
                mp.put(sum, i);
            }
            ans = Math.max(ans, i - mp.get(sum));
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.err.println(findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
        System.err.println(findMaxLength(new int[]{0,0,1,1,0,1}));
        System.err.println(findMaxLength(new int[]{1,1,1,1,1,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0}));
    }   
}

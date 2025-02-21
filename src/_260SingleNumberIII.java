public class _260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int ax = 0;
        for(int i : nums)
            ax ^= i;
        
        int bit = ax & (-ax);
        int setA = 0, setB = 0;
        
        for(int i: nums){
            if((i & bit) == 0)
                setA ^= i;
            else
                setB ^= i;
        }

        return new int[]{setA, setB};
    }

    public static void main(String[] args) {
        _260SingleNumberIII ob = new _260SingleNumberIII();
        System.out.println(ob.singleNumber(new int[]{1,2,1,3,2,5}));
    }
}

class _134GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = gas[0] - cost[0];
        int st = gas.length - 1;
        int cur = gas[0];
        int min = cur;
        int max = cur;

        for(int i = 1; i < gas.length; ++i){
            total = total + gas[i] - cost[i];
            cur = cur + gas[i] - cost[i-1];

            if(cur < min){
                cur = gas[i];
                min = cur;
                max = cur;
            }
            if(cur >= max){
                st = i;
                max = cur;
            }
        }

        if(total < 0){
            return -1;
        }

        return st;
    }

    
    public static void main(String[] args) {
        //System.out.println(canCompleteCircuit(new int[]{5,8,2,8}, new int[]{6,5,6,6}));
        //System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}

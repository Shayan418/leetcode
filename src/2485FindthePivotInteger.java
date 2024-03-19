class _2485FindthePivotInteger {
    public int helper(int n){
        return (n * (n+1)) / 2;
    }
    
    public int pivotInteger(int n) {
        
        for(int i = 1; i <= n; ++i){
            int left = helper(i);
            int right = helper(n) - left + i;

            if(left == right){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        _2485FindthePivotInteger ob = new _2485FindthePivotInteger();

        System.out.println(ob.pivotInteger(1));
    }
}

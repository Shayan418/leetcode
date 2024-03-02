class _342PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if(n < 0){
            return false;
        }

        int x = n;
        int count = 0;
        while (x > 0) {
            count = count +  (x & 1);
            x = x >> 1;
        }
        
        if(count > 1){
            return false;
        }
        for(int i = 1; i<= 16; ++i){
            if((n & 1) == 1){
                return true;
            }

            n = n >> 2;
        }

        return false;

    }


    public static void main(String[] args) {
        _342PowerOfFour ob = new _342PowerOfFour();

        System.out.println(ob.isPowerOfFour(1073741824));
    }
}

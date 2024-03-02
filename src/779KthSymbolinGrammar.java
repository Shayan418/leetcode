class _779KthSymbolinGrammar {
    public int kthGrammar(int n, int k) {
        if(k == 1){
            return 0;
        }

        int temp = k;
        if((k & 1) == 1){
            ++temp;
        }
        temp /= 2;
        
        int val = kthGrammar(n, temp);

        if(val == 0){
            val = ((k & 1) == 1)? 0 : 1;
        } else {
            val = ((k & 1) == 1)? 1 : 0;
        }

        return val;
    }


    public static void main(String[] args) {
        _779KthSymbolinGrammar ob= new _779KthSymbolinGrammar();

        System.out.println(ob.kthGrammar(2, 2));
    }
}

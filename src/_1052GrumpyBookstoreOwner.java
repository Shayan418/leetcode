public class _1052GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int ans = 0;
        int happy = 0; 

        for(int i = 0 ; i < customers.length; ++i){
            if(grumpy[i] == 0){
                happy += customers[i];
            }
        }

        int window_sum = 0;

        for(int i = 0 ; i < minutes; ++i){
            if(grumpy[i] == 1){
                window_sum += customers[i];
            }
        }

        ans = Math.max(ans, happy + window_sum);

        int left = 0;
        int right = minutes - 1;

        while (right + 1 < customers.length) {
            if(grumpy[left] == 1)
                window_sum -= customers[left];
            
            ++left;
            ++right;

            if(grumpy[right] == 1)
                window_sum += customers[right];
            
            ans = Math.max(ans, happy + window_sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        _1052GrumpyBookstoreOwner ob = new _1052GrumpyBookstoreOwner();
        System.out.println(ob.maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }
}

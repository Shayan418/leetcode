import java.util.ArrayList;
import java.util.Collections;


class _1356SortIntegersbyTheNumberof1Bits {
   public int setbits(int n){
        int count = 0;

        while(n > 0){
            if((n & 1) == 1){
                ++count;
            }
            n = n >> 1;
        }

        return count;
    }
    public int[] sortByBits(int[] arr) {
        
        ArrayList<Integer> sorted = new ArrayList<>();
        for(int n: arr){
            sorted.add(n);
        }

        Collections.sort(sorted, (Integer o1, Integer o2) -> {
            int x = setbits(o1.intValue()); 
            int y = setbits(o2.intValue());
            if(x == y){
                return o1 - o2;
            }
            return x - y;
        });

        arr = sorted.stream().mapToInt(i -> i).toArray();
    
        return arr;
    
    } 

    public static void main(String[] args) {
        _1356SortIntegersbyTheNumberof1Bits ob = new _1356SortIntegersbyTheNumberof1Bits();

        int[] ans = ob.sortByBits(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});

        for(int n: ans){
            System.out.print(n + " ");
        }
    }

}

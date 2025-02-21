import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _881BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int l = 0;
        int r = people.length - 1;

        while (people[r] == limit) {
            --r;
            ++ans;
        }

        while (l < r) {
            if(people[l] + people[r] <= limit){
                ++ans;
                ++l;
                --r;
            } else {
                --r;
                ++ans;
            }
        }

        if(l == r){
            ++ans;
        }

        return ans;

    }


    public static void main(String[] args) {
        _881BoatstoSavePeople ob = new _881BoatstoSavePeople();

        System.out.println(ob.numRescueBoats(new int[]{3,5,3,4}, 5));

        new Thread(() -> {
            System.out.println("test");
        }).start();


        List<String> arr = new ArrayList<>(Arrays.asList("apple", "guava", "mango"));
        Comparator<String> cmp = (s1,s2) -> s2.compareTo(s1);
        Collections.sort(arr, cmp);
        System.out.println(arr);

    }
}

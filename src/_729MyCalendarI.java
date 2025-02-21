
import java.util.Map;
import java.util.TreeMap;

public class _729MyCalendarI {

    TreeMap<Integer, Integer> map;

    public _729MyCalendarI() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (map.containsKey(start)) {
            return false;
        }

        if(map.isEmpty()){
            map.put(start, end);
            return true;
        }

        Map.Entry<Integer, Integer> before = map.lowerEntry(start);
        Map.Entry<Integer, Integer> after = map.higherEntry(start);


        if(before != null && start < before.getValue()){
            return false;
        }

        if(after != null && end > after.getKey()){
            return false;
        }

        map.put(start, end);
        return true;
    }


    public static void main(String[] args) {

        _729MyCalendarI calendar = new _729MyCalendarI();

        System.out.println(calendar.book(47,50));
        System.out.println(calendar.book(33,41));
        System.out.println(calendar.book(39,45));
        System.out.println(calendar.book(33,42));
        System.out.println(calendar.book(25,32));
        System.out.println(calendar.book(26,35));
        System.out.println(calendar.book(19,25));

    }

}

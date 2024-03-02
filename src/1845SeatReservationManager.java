import java.util.Collections;
import java.util.PriorityQueue;

class SeatManager {

    PriorityQueue<Integer> pq;
    PriorityQueue<Integer> pqmin;
    int max;

    public SeatManager(int n) {
        pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pqmin = new PriorityQueue<Integer>();
        max = n;
        for (int i = 1; i <= n; ++i) {
            pqmin.add(i);
        }
    }

    public int reserve() {

        pq.add(pqmin.peek());
        return pqmin.poll();

    }

    public void unreserve(int seatNumber) {
        pq.remove(seatNumber);
        pqmin.add(seatNumber);

    }
}

class _1845SeatReservationManager {

    public static void main(String[] args) {
        SeatManager ob = new SeatManager(4);
        System.out.println(ob.reserve());
        ob.unreserve(1);
        System.out.println(ob.reserve());
        System.out.println(ob.reserve());
        System.out.println(ob.reserve());
        ob.unreserve(2);
        System.out.println(ob.reserve());
        ob.unreserve(1);
        System.out.println(ob.reserve());
        ob.unreserve(2);

    }
}

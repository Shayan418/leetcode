import java.util.*;

public class _1942TheNumberoftheSmallestUnoccupiedChair {
    static class data{
        public int arrivalTime;
        public int departureTime;
        public int friend;
        public data(int arrivalTime, int departureTime, int friend) {
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
            this.friend = friend;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {

        List<data> dataList = new ArrayList<>();


        PriorityQueue<Integer> availableSeat = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            availableSeat.add(i);
            dataList.add(new data(times[i][0], times[i][1], i));
        }

        dataList.sort(Comparator.comparingInt(data -> data.arrivalTime));
        PriorityQueue<int[]> occupiedSeat_departureTime = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int i;
        for(i = 0; dataList.get(i).friend != targetFriend; i++) {
            while (!occupiedSeat_departureTime.isEmpty() && occupiedSeat_departureTime.peek()[1] <= dataList.get(i).arrivalTime) {
                availableSeat.add(occupiedSeat_departureTime.poll()[0]);
            }
            if(!availableSeat.isEmpty()) {
                int seat = availableSeat.poll();
                occupiedSeat_departureTime.add(new int[]{seat, dataList.get(i).departureTime});
            }
        }

        while (!occupiedSeat_departureTime.isEmpty() && occupiedSeat_departureTime.peek()[1] <= dataList.get(i).arrivalTime) {
            availableSeat.add(occupiedSeat_departureTime.poll()[0]);
        }

        return !availableSeat.isEmpty() ? availableSeat.peek() : -1;

    }


    public static void main(String[] args) {
        _1942TheNumberoftheSmallestUnoccupiedChair ob = new _1942TheNumberoftheSmallestUnoccupiedChair();

//        System.out.println(ob.smallestChair(new int[][]{{1,4},{2,3},{4,6}}, 1));

//        System.out.println(ob.smallestChair(new int[][]{{3,10},{1,5},{2,6}}, 0));

System.out.println(ob.smallestChair(new int[][]{{33,35},{26,29},{9,28},{4,31},{8,10},{32,34},{15,24},{27,39},{14,36},{1,14},{25,39},{5,27},{6,15},{2,38},{19,36},{24,34},{3,26}}, 0));

        //System.out.println(ob.smallestChair(new int[][]{{4,5},{6,8},{8,10},{1,8}}, 2));

    }
}

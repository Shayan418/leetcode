import java.util.Arrays;
import java.util.PriorityQueue;

class _2402MeetingRoomsIII {
    public int mostBooked(int n, int[][] meetings) {
        
        int[] used = new int[n];


        Arrays.sort(meetings, (int[] a, int[] b) ->  a[0] - b[0]);
        
        PriorityQueue<Integer> emptyRooms = new PriorityQueue<>();
        PriorityQueue<int[]> inProg = new PriorityQueue<>((int[] a, int[] b) ->  {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });


        for(int i =0 ; i < n; ++i){
            emptyRooms.add(i);
        }
        
        //int currMeet = 0;
        // for(int i = 0; i < 1000000; ++i){
        //     if(currMeet == meetings.length){ break; }
            
        //     int[] meeting  = meetings[currMeet];

        //     while(!inProg.isEmpty() && inProg.peek()[1] == i){
        //         int[] willEnd = inProg.poll();
        //         emptyRooms.add(willEnd[0]);
        //     }

        //     while(!emptyRooms.isEmpty() && meeting[0] <= i){
                
        //         int startOffset = i - meeting[0];
        //         int room = emptyRooms.poll();
        //         ++used[room];
        //         inProg.add(new int[] { room ,meeting[1] + startOffset});
                
        //         ++currMeet;
        //         if(currMeet == meetings.length){
        //             meeting[0] = Integer.MAX_VALUE;
        //         } else {
        //             meeting = meetings[currMeet];
        //         }
        //     }
        // }

        for(int[] meeting: meetings){

            while (!inProg.isEmpty() && inProg.peek()[1] <= meeting[0]) {
                emptyRooms.add(inProg.poll()[0]);
            }

            if(!emptyRooms.isEmpty()){
                int room = emptyRooms.poll();
                ++used[room];
                inProg.add(new int[] { room ,meeting[1]});
            } else {
                int[] latest = inProg.poll();
                int startOffset = latest[1] - meeting[0];

                int room = latest[0];

                ++used[room];
                inProg.add(new int[] { room ,meeting[1] + startOffset});
            }

        }

        emptyRooms.clear();
        inProg.clear();

        int ans = -1;
        int ansMax = -1;
        for(int i = 0; i < used.length; ++i){
            if(used[i] > ansMax){
                ans = i;
                ansMax = used[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _2402MeetingRoomsIII ob = new _2402MeetingRoomsIII();

        //System.out.println(ob.mostBooked(2, new int[][]{{0,10},{1,5},{2,7},{3,4}}));
        //System.out.println(ob.mostBooked(2, new int[][]{{43,44},{34,36},{11,47},{1,8},{30,33},{45,48},{23,41},{29,30}}));
        System.out.println(ob.mostBooked(2, new int[][]{{1,10},{2,10},{3,10},{4,10},{5,10},{6,10},{7,10}}));
        
    
    }
}

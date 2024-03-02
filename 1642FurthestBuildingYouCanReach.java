import java.util.Collections;
import java.util.PriorityQueue;

class _1642FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] h, int bricks, int ladders) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  

        for(int i = 0; i < h.length - 1; ++i){
            int diff = h[i+1] - h[i];  
            if(diff <= 0){
                continue;
            }

            if(diff <= bricks){
                pq.add(diff);
                bricks -= diff;
            } else if (ladders > 0) {
                --ladders;
                if(!pq.isEmpty() && pq.peek() > diff){
                    bricks += pq.poll();
                    pq.add(diff);
                    bricks -= diff;
                }

            } else {
                System.gc();
                return i;
            }
        }

        // for(int i = 0; i < h.length - 1; ++i){
        //     int diff = h[i+1] - h[i];  
        //     if(diff <= 0){
        //         continue;
        //     }

        //     pq.add(diff);
        //     bricks -= diff;
            
        //     if(bricks < 0){
        //         if (ladders <= 0) {
        //             System.gc();
        //             return i;
        //         }
        //         bricks += pq.poll();
        //         --ladders;
        //     }
        // }

        System.gc();
        return h.length - 1;
    }

    public static void main(String[] args) {
        _1642FurthestBuildingYouCanReach ob = new _1642FurthestBuildingYouCanReach();

        System.out.println(ob.furthestBuilding(new int[] { 4, 2, 7, 6, 9, 14, 12 }, 5, 1));
        System.out.println(ob.furthestBuilding(new int[] { 4, 12, 2, 7, 3, 18, 20, 3, 19 }, 10, 2));

    }
}

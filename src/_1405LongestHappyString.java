import java.util.ArrayList;
import java.util.PriorityQueue;

public class _1405LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[1] - x[1]);

        pq.add(new int[]{'a',a});
        pq.add(new int[]{'b',b});
        pq.add(new int[]{'c',c});

        StringBuilder sb = new StringBuilder();

        int[] temp = {0,0};
        int[] aux = {0,0};

        while (!pq.isEmpty()) {
            temp = pq.poll();

            if(!sb.isEmpty() && sb.charAt(sb.length()-1) == temp[0]) {
                if(pq.isEmpty()) {
                    break;
                }
                aux = pq.poll();
                pq.add(temp);
                temp = aux;
            }

            if(temp[1] > 0){
                sb.append((char)temp[0]);
                --temp[1];
            }
            if(temp[1] > 0){
                if (pq.isEmpty() || pq.peek()[1] <= temp[1]) {
                    sb.append((char)temp[0]);
                    --temp[1];
                }
            }

            if(temp[1] > 0){
                pq.add(temp);

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _1405LongestHappyString obj = new _1405LongestHappyString();
        System.out.println(obj.longestDiverseString(0,8,11));
        System.out.println(obj.longestDiverseString(1,1,7));
    }

}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _950RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Queue<Integer> q = new LinkedList<>();
        q.add(deck[deck.length - 1]);

        for(int i = deck.length - 2; i >= 0; --i){
            q.add(q.poll());
            q.add(deck[i]);
        }

        for(int i = deck.length - 1; i >= 0; --i){
            deck[i] = q.poll().intValue();
        }
        q = null;
        return deck;
    }

    public static void main(String[] args) {
        _950RevealCardsInIncreasingOrder ob= new _950RevealCardsInIncreasingOrder();

        System.out.println(ob.deckRevealedIncreasing(new int[]{1, 1000}));
        System.out.println(ob.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7}));
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

class _402RemoveKDigits {
    // public String removeKdigits(String num, int k) {
    // int len = num.length() - k - 1;

    // int prev = -1;
    // int prev2 = -1;
    // StringBuilder sb = new StringBuilder();

    // int min = Integer.MAX_VALUE;
    // int min2 = Integer.MAX_VALUE;

    // while (len >= 0) {
    // min2 = Integer.MAX_VALUE;
    // for (int i = prev + 1; i < num.length() - len; ++i) {
    // int val = Character.getNumericValue(num.charAt(i));
    // if (val < min) {
    // min = val;
    // prev = i;
    // continue;
    // }

    // if (val >= min && val < min2) {
    // min2 = val;
    // prev2 = i;
    // }

    // }
    // sb.append(min);
    // --len;

    // if (min2 == Integer.MAX_VALUE || prev2 < prev) {
    // min = Integer.MAX_VALUE;
    // } else {
    // min = min2;
    // prev = prev2;
    // }
    // }

    // while (sb.length() > 0 && sb.charAt(0) == '0') {
    // sb.deleteCharAt(0);
    // }

    // return sb.length() == 0 ? "0" : sb.toString();
    // }

    public String removeKdigits(String num, int k) {
        int len = num.length() - k;
        
        if(len == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();

        int idx = 0;
        while (idx < num.length() && idx < num.length() - len + 1) {
            int val = Character.getNumericValue(num.charAt(idx));
            if (dq.isEmpty()) {
                dq.add(val);
            } else {
                while (!dq.isEmpty() && dq.peekFirst() > val) {
                    dq.removeFirst();
                }
                dq.addFirst(val);
            }
            ++idx;
        }

        sb.append(dq.pollLast());

        while (idx < num.length()) {
            int val = Character.getNumericValue(num.charAt(idx));
            while (!dq.isEmpty() && dq.peekFirst() > val) {
                dq.removeFirst();
            }
            dq.addFirst(val);
            sb.append(dq.pollLast());
            ++idx;
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
        sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        _402RemoveKDigits ob = new _402RemoveKDigits();
        System.out.println(ob.removeKdigits("9", 1));
        System.out.println(ob.removeKdigits("10200", 1));
        System.out.println(ob.removeKdigits("1432219", 3));

    }
}

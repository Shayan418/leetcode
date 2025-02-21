import java.util.List;
import java.util.ArrayList;

public class _592FractionAdditionandSubtraction {
    public String fractionAddition(String exp) {
        int l = 0;
        int r = 1;

        List<int[]> nums = new ArrayList<>();

        while (r <= exp.length()) {
            int[] temp = new int[2];

            while (exp.charAt(r) != '/') {
                ++r;
            }

            temp[0] = Integer.parseInt(exp.substring(l, r));
            l = r + 1;
            r = l + 1;
            //System.out.println(r);
            while (r < exp.length() && exp.charAt(r) != '-' && exp.charAt(r) != '+') {
                ++r;
            }

            temp[1] = Integer.parseInt(exp.substring(l, r));
            l = r;
            r = l + 1;
            nums.add(temp);
        }

        // for (int[] num : nums) {
        //     System.out.println(num[0] + " " + num[1]);
        // }

        int numerator = 0;
        int denominator = 0;

        denominator = nums.stream().mapToInt(x -> x[1]).reduce(1, Math::multiplyExact);

        // for (int[] num : nums) {
        //     int factor = denominator / num[1];
        //     numerator += (num[0] * factor);
        // }

        final int tempDenom = denominator;
        numerator = nums.stream().mapToInt(num -> num[0] * (tempDenom / num[1])).sum();

        int gcd = gcd(Math.abs(numerator),Math.abs(denominator));

        numerator = numerator / gcd;
        denominator = denominator / gcd;

        return Integer.toString(numerator).concat("/").concat(Integer.toString(denominator));
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        _592FractionAdditionandSubtraction ob = new _592FractionAdditionandSubtraction();

        System.out.println(ob.fractionAddition("-1/2+1/2-1/3"));
    }
}

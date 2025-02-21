public class _670MaximumSwap {
    public int maximumSwap(int num) {
        int[] digits = Integer.toString(num).chars().map(c -> c-'0').toArray();

        for(int i = 0; i < digits.length; i++) {
            int maxIdx = -1;
            int max = Integer.MIN_VALUE;
            for(int j = digits.length-1; j > i; j--) {
                if(digits[j] > max) {
                    max = digits[j];
                    maxIdx = j;
                }
            }
            if(maxIdx == -1 || max <= digits[i]){
                continue;
            }
            digits[maxIdx] = digits[i];
            digits[i] = max;
            break;
        }

        int ans = 0;
        for (int digit : digits) {
            ans = ans*10 + digit;
        }
        return ans;
    }

    public static void main(String[] args) {
        _670MaximumSwap solution = new _670MaximumSwap();
        System.out.println(solution.maximumSwap(2736));
    }

}

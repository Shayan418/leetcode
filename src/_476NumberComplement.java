public class _476NumberComplement {
    public int findComplement(int num) {
        int ans = Integer.MAX_VALUE ^ num;

        int count = 1;
        while((ans & (1 << 30)) != 0){
            ans = ans << 1;
            ++count;
        }
        ans = ans << 1;

        System.out.println((ans & (1 << 30)) );
        System.out.println(ans);
        ans = ans >>> count;
        return ans;
    }

    public static void main(String[] args) {
        _476NumberComplement ob = new _476NumberComplement();

        System.out.println(ob.findComplement(0));
    }
}

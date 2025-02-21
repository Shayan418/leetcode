public class _564FindtheClosestPalindrome {
    public String nearestPalindromic(String str) {
        long n = Long.valueOf(str);

        long left = nearestleft(0L, n, n);
        long right = nearestright(n, Long.MAX_VALUE-1, n);

        
        if(n-left <= right-n){
            return Long.toString(left);
        } else{
            return Long.toString(right);
        }
    }

    public long toPali(long n){
        char[] arr = Long.toString(n).toCharArray();
        int last = arr.length - 1;
        for (int i =0 ; i < arr.length/2; ++i){
            arr[last - i] = arr[i];
        }
        return Long.valueOf(new String(arr));
    }

    public long nearestleft(long l, long h, long n){
        long mid = l + (h - l)/ 2;
        long ans = 0L;
        while(l <= h){
            mid = l + (h - l)/ 2;
            long pal = toPali(mid);

            if(pal < n){
                l = mid + 1;
                ans = pal;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public long nearestright(long l, long h, long n){
        long mid = l + (h - l)/ 2;
        long ans = Long.MAX_VALUE;
        while(l <= h){
            mid = l + (h - l)/ 2;
            long pal = toPali(mid);

            if(pal > n){
                h = mid - 1;
                ans = pal;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        _564FindtheClosestPalindrome ob = new _564FindtheClosestPalindrome();

System.out.println(ob.nearestPalindromic("99"));
        //System.out.println(ob.nearestPalindromic("123"));
    }
}

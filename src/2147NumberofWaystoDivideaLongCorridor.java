class _2147NumberofWaystoDivideaLongCorridor {
    public int numberOfWays(String corridor) {

        int seat_count = 0;
        int ans = 1;

        for (int i = 0; i < corridor.length(); ++i) {
            if (corridor.charAt(i) == 'S') {
                ++seat_count;
            }

            if (seat_count == 2) {
                seat_count = 0;
                int plant_count = 0;
                int temp = i+1;

                while (temp < corridor.length() && corridor.charAt(temp) == 'P') {
                    ++plant_count;
                    ++temp;
                }
                i = temp-1;

                if (temp == corridor.length() || plant_count == 0) {
                    continue;
                }

            }


        }

        if (seat_count == 1) {
            return 0;
        }

        return ans;

    }

    public static void main(String[] args) {
        _2147NumberofWaystoDivideaLongCorridor ob = new _2147NumberofWaystoDivideaLongCorridor();

        System.out.println(ob.numberOfWays("SSSPS"));
    }
}
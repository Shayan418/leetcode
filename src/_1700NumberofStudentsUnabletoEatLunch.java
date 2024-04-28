public class _1700NumberofStudentsUnabletoEatLunch {
    public int stIdx(int[] students, int idx, int key) {
        int x = idx;
        while (x < students.length && students[x] != key) {
            ++x;
        }

        if(x < students.length && students[x] == key){
            return x;
        }

        x = 0;
        while (x < idx && students[x] != key) {
            ++x;
        }

        return x;

    }

    public int countStudents(int[] students, int[] sandwiches) {

        int idx = 0;
        for (int i = 0; i < sandwiches.length; i++) {
            int nextStudent = stIdx(students, idx, sandwiches[i]);

            if (sandwiches[i] == students[nextStudent]) {
                students[nextStudent] = -1;
                continue;
            }
            idx = nextStudent;
            if (idx == nextStudent) {
                return sandwiches.length - i + 1;
            }
        }

        return 0;
    }

    public int countStudents2(int[] students, int[] sandwiches) {
        
        int zeros = 0;
        int ones = 0;

        for(int n: students){
            zeros = (n == 0) ? zeros + 1: zeros;
            ones = (n == 1) ? ones + 1 : ones;
        }

        for(int i = 0; i < sandwiches.length; ++i){
            if((zeros == 0  && sandwiches[i] == 0) || (ones == 0 && sandwiches[i] == 1)){
                return sandwiches.length - i;
            }

            zeros = (sandwiches[i] == 0) ? zeros - 1 : zeros;
            ones = (sandwiches[i] == 1) ? ones - 1: ones;
        }

        return 0;
    }

    public static void main(String[] args) {
        _1700NumberofStudentsUnabletoEatLunch ob = new _1700NumberofStudentsUnabletoEatLunch();
        System.out.println(ob.countStudents2(new int[]{1,0,1,0,1,1,0,1,1,1,1,0,0,0,1,1,1,0,1,1,1,1,0,0,0,1,0,0,0,0}, new int[]{0,1,0,0,1,1,1,1,1,1,0,1,1,0,0,0,1,1,0,0,1,1,1,1,0,0,1,0,1,0}));

    }

}

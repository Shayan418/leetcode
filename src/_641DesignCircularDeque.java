public class _641DesignCircularDeque {
    int[] arr;
    int n;
    int l, r;

    public _641DesignCircularDeque(int k) {
        n = k;
        arr = new int[n];
        l = -1;
        r = -1;
    }

    public boolean insertFront(int value) {
        if(isFull())
            return false;
        if(l == -1){
            l = r = 0;
            arr[l] = value;
            return true;
        }
        --l;
        if(l == -1){
            l = n-1;
        }
        arr[l] = value;

        return true;
    }

    public boolean insertLast(int value) {
        if(isFull())
            return false;

        if(l == -1){
            l = r = 0;
            arr[l] = value;
            return true;
        }

        ++r;
        if(r == n)
            r = 0;
        arr[r] = value;

        return true;
    }

    public boolean deleteFront() {
        if(isEmpty())
            return false;

        if(l == r){
            l = -1;
            r = -1;
            return true;
        }

        ++l;
        if(l == n)
            l = 0;

        return true;
    }

    public boolean deleteLast() {
        if(isEmpty())
            return false;

        if(l == r){
            l = -1;
            r = -1;
            return true;
        }
        --r;
        if(r == -1){
            r = n-1;
        }
        return true;
    }

    public int getFront() {
        return l == -1 ? l : arr[l];
    }

    public int getRear() {
        return r == -1 ? r : arr[r];
    }

    public boolean isEmpty() {
        return l == -1;
    }

    public boolean isFull() {
        return (l == 0 && r == n-1) || (l == r+1);
    }

    public static void main(String[] args) {
        _641DesignCircularDeque ob = new _641DesignCircularDeque(4);


        System.out.println(ob.isFull());
        System.out.println(ob.isEmpty());

//        System.out.println(ob.insertFront(93));
//        System.out.println(ob.insertLast(578));
//        System.out.println(ob.deleteFront());
//        System.out.println(ob.getFront());
//        System.out.println(ob.deleteLast());
//        System.out.println(ob.insertLast(533));
//        System.out.println(ob.isEmpty());
//        System.out.println(ob.deleteLast());
//        System.out.println(ob.insertFront(913));
//        System.out.println(ob.getRear());
//        System.out.println(ob.deleteFront());
//        System.out.println(ob.insertFront(100));
//        System.out.println(ob.insertLast(57));
//        System.out.println(ob.deleteLast());
//        System.out.println(ob.getFront());
//        System.out.println(ob.getRear());
//        System.out.println(ob.insertFront(900));
//        System.out.println(ob.getRear());
//        System.out.println(ob.getFront());


        System.out.println(ob.insertFront(9));
        System.out.println(ob.deleteLast());
        System.out.println(ob.getRear());
        System.out.println(ob.getFront());
        System.out.println(ob.getFront());
        System.out.println(ob.deleteFront());
        System.out.println(ob.insertFront(6));
        System.out.println(ob.insertLast(5));
        System.out.println(ob.insertFront(9));
        System.out.println(ob.getFront());
        System.out.println(ob.insertFront(6));

        System.out.println(ob.isFull());
        System.out.println(ob.isEmpty());


    }
}





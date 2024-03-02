public class functionsTest {

    public static class rectangle {
        
        int class_l;
        int class_b;

        public rectangle(int func_l, int func_b) {
            class_l = func_l;
            class_b = func_b;
        }

        public rectangle(){
            class_b = 5;
            class_l = 5;
        }

        public void area() {
            int area = class_l * class_b;
            System.out.println("area" + " " + area);
        }

        public void perimeter() {
            int perimeter = 2 * (class_l + class_b);
            System.out.println("perimeter" + " " + perimeter);
        }

    }

    public static void main(String[] args) {

        rectangle ob1 = new rectangle(4, 5);
        ob1.area();
        ob1.perimeter();

        rectangle ob2 = new rectangle(6, 2);
        ob2.area();

        rectangle ob3 = new rectangle(3, 3);
        ob3.perimeter();

        rectangle ob4 = new rectangle();
        ob4.area();
    }
}

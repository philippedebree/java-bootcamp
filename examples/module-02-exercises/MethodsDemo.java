public class MethodsDemo {
    public static int square(int n) {
        return n * n;
    }

    public static double square(double n) {
        return n * n;
    }

    public static void main(String[] args) {
        int overload1 = square(4);
        double overload2 = square(2.5);
        System.out.println("square(4) = " + overload1);
        System.out.println("square(2.5) = " + overload2);
    }
}

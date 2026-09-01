public class Methods {
    public static void main(String[] args) {
        // TODO: int sum = add(10, 20); then print sum
        // TODO: String message = greet("Aman"); then print message
        //throw new UnsupportedOperationException("TODO: call add and greet");
        int sum = add(10, 20);
        System.out.println(sum);

        String message = greet("Aman");
        System.out.println(message);
    }

    public static int add(int a, int b) {
        return a + b;
        //throw new UnsupportedOperationException("TODO");
    }

    public static String greet(String name) {
        return "Hello, " + name + "!";
        //throw new UnsupportedOperationException("TODO");
    }
}

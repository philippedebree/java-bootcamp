public class StringBuilderComparison {
    private static final int ITERATIONS = 50_000;

    static String withString() {
        String result = "";
        for (int i = 0; i < ITERATIONS; i++) {
            result += "x";
        }
        return result;
    }

    static String withBuilder() {
        StringBuilder result = new StringBuilder(ITERATIONS);
        for (int i = 0; i < ITERATIONS; i++) {
            result.append('x');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        long stringStart = System.nanoTime();
        String stringResult = withString();
        long stringNanos = System.nanoTime() - stringStart;

        long builderStart = System.nanoTime();
        String builderResult = withBuilder();
        long builderNanos = System.nanoTime() - builderStart;

        System.out.printf("String: %s char, %.3f ms%n", ITERATIONS, stringNanos / 1_000_000.0);
        System.out.printf("StringBuilder: %s char, %.3f ms", ITERATIONS, builderNanos / 1_000_000.0);
    }
}
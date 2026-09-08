public class ThrowThrowsDemo {
    // TODO: declare throws if using a checked exception in your design
    static void requirePositive(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        System.out.println("Amount ok: " + amount);
    }

    public static void main(String[] args) {
        try {
            requirePositive(-5);
        } catch (IllegalArgumentException ex) {
            System.out.println("Rejected: " + ex.getMessage());
        }
        requirePositive(25);
    }
}

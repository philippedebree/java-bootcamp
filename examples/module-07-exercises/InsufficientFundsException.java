public class InsufficientFundsException extends Exception {
    private final double balance;
    private final double requested;

    public InsufficientFundsException(double balance, double requested) {
        super("Insufficient balance in account.");
        this.balance = balance;
        this.requested = requested;
    }

    public double getBalance() { return balance; }
    public double getRequested() { return requested; }
    public double getShortfall() { return requested - balance; }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(100);
        CurrentAccount current = new CurrentAccount(100);
        Account[] accounts = {
                savings,
                current
        };

        for (Account account : accounts) {
            account.withdraw(20.00);
            System.out.printf("%s balance: %.2f%n",
                    account.getAccountType(),
                    account.getBalance());
        }
    }
}
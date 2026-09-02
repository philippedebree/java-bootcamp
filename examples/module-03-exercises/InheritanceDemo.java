public class InheritanceDemo {
    public static void main(String[] args) {
        //SavingsAccount savings = new SavingsAccount(100);
        //CurrentAccount current = new CurrentAccount(100);
        Account[] accounts = {
                new SavingsAccount(100),
                new CurrentAccount(100),
                new FrozenAccount(100)
        };

        for (Account account : accounts) {
            boolean ok = account.withdraw(20.00);
            System.out.printf("%s withdraw=%s balance: %.2f%n",
                    account.getAccountType(),
                    ok,
                    account.getBalance());
        }
    }
}
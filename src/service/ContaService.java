

public class ContaService {

    public void deposit(Account account, double value) {
        account.deposit(value);
    }

    public void withdraw(Account account, double value) {
        account.withdraw(value);
    }

    public void statement(Account account) {
        account.printStatement();
    }
}
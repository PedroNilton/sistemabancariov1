

public abstract ContaCorrente extends Conta {

    @Override
    public void withdraw(double value) {
        if (value > balance) {
            throw new BalanceInsufficientException
        }
        balance -= value;
        extract.add(new Transaction("WITHDRAW", value));
    }
}
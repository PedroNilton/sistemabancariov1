

public abstract class Conta {

    protected String number;
    protected Cliente client;
    protected double balance;
    protected List<transaction> extract;

    public abstract void withdraw (double value);

    public void deposit (double value) {
        balance += value;
        extract.add(new Transaction("DEPOSIT", value));
    }
}
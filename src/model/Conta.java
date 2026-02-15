

public abstract class Conta {

    protected String number;
    protected Cliente client;
    protected double balance;
    protected List<transacao> extract;

    public abstract void withdraw (double value);

    public void deposit (double value) {
        balance += value;
        extract.add(new Transacao("DEPOSIT", value));
    }

    public void setInitialBalance (double value) {
        this.value = value;
    }
}
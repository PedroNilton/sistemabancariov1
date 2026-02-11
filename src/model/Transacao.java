

public class Transaction {

    private String tipo;
    private double value;
    private LocalDateTime data;

    public Transaction(String tipo, double value) {
        this.tipo = tipo;
        this.value = value;
        this.data = LocalDateTime.now();
    }
}
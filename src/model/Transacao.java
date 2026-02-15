package model;

import java.time.LocalDateTime;

public class Transacao {

    private String tipo;
    private double value;
    private LocalDateTime data;

    public Transacao(String tipo, double value) {
        this.tipo = tipo;
        this.value = value;
        this.data = LocalDateTime.now();
    }
}
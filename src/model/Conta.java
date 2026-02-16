package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    protected String numero;
    protected Cliente cliente;
    protected double saldo;
    protected List<Transacao> extrato = new ArrayList<>();

    public Conta(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public abstract void sacar(double valor);

    public void depositar(double valor) {
        saldo += valor;
        extrato.add(new Transacao("DEPÓSITO", valor));
    }

    public void definirSaldoInicial(double valor) {
        this.saldo = valor;
    }

    public void imprimirExtrato() {
        System.out.println("\n=== EXTRATO ===" + numero + " ===");
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Saldo atual: " + saldo);
        System.out.println("Transações: ");

        for (Transacao t : extrato) {
            System.out.println(t);
        }
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }
}

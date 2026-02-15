package model;

import exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

    public ContaCorrente(String numero, Cliente cliente) {
        super(numero, cliente);
    }

    @Override
    public void sacar(double valor) {

        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }

        saldo -= valor;
        extrato.add(new Transacao("SAQUE", valor));
    }
}

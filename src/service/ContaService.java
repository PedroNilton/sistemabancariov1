package service;

import model.Conta;

public class ContaService {

    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public void sacar(Conta conta, double valor) {
        conta.sacar(valor);
    }

    public void extrato(Conta conta) {
        conta.imprimirExtrato();
    }
}

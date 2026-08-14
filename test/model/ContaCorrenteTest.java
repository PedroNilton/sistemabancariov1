package model;

import exception.SaldoInsuficienteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaCorrenteTest {

    @Test
    void depositaESacaValoresValidos() {
        Conta conta = new ContaCorrente("001", new Cliente("Pedro", "12345678900"));

        conta.depositar(200.0);
        conta.sacar(50.0);

        assertEquals(150.0, conta.getSaldo());
    }

    @Test
    void rejeitaSaqueSemSaldoSuficiente() {
        Conta conta = new ContaCorrente("001", new Cliente("Pedro", "12345678900"));
        conta.depositar(100.0);

        assertThrows(SaldoInsuficienteException.class, () -> conta.sacar(150.0));
        assertEquals(100.0, conta.getSaldo());
    }

    @Test
    void rejeitaSaqueComValorNaoPositivo() {
        Conta conta = new ContaCorrente("001", new Cliente("Pedro", "12345678900"));

        assertThrows(SaldoInsuficienteException.class, () -> conta.sacar(0.0));
        assertThrows(SaldoInsuficienteException.class, () -> conta.sacar(-10.0));
    }
}

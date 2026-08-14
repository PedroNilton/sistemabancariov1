package service;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import org.junit.jupiter.api.Test;
import repository.ContaRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BancoServiceTest {

    @Test
    void criaContasETransfereSaldo() {
        BancoService service = new BancoService(new InMemoryContaRepository());
        Conta origem = new ContaCorrente("001", new Cliente("Pedro", "12345678900"));
        Conta destino = new ContaCorrente("002", new Cliente("Maria", "98765432100"));

        service.criarConta(origem);
        service.criarConta(destino);
        origem.depositar(200.0);

        service.transferir("001", "002", 75.0);

        assertEquals(125.0, origem.getSaldo());
        assertEquals(75.0, destino.getSaldo());
    }

    @Test
    void rejeitaNumeroOuCpfDuplicado() {
        BancoService service = new BancoService(new InMemoryContaRepository());
        service.criarConta(new ContaCorrente("001", new Cliente("Pedro", "12345678900")));

        assertThrows(
                IllegalArgumentException.class,
                () -> service.criarConta(new ContaCorrente("001", new Cliente("Maria", "98765432100")))
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> service.criarConta(new ContaCorrente("002", new Cliente("Outro Pedro", "12345678900")))
        );
    }

    private static final class InMemoryContaRepository implements ContaRepository {

        private final Map<String, Conta> contas = new HashMap<>();

        @Override
        public void salvar(Map<String, Conta> contas) {
            this.contas.clear();
            this.contas.putAll(contas);
        }

        @Override
        public Map<String, Conta> carregar() {
            return new HashMap<>(contas);
        }
    }
}

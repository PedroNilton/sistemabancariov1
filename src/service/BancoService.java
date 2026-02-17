package service;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import repository.ContaRepository;
import exception.ContaNaoEncontradaException;

import java.util.Map;

public class BancoService {

    private final ContaRepository repository;
    private Map<String, Conta> contas;

    public BancoService(ContaRepository repository) {
        this.repository = repository;
        this.contas = repository.carregar();
    }

    public Conta criarConta(Cliente cliente) {

        if (cpfJaExiste(cliente.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }

        String numero = String.valueOf(sequencia++);
        Conta conta = new ContaCorrente(numero, cliente);

        contas.put(numero, conta);

        return conta;
    }

    public Conta buscarConta(String numero) {

        Conta conta = contas.get(numero);

        if (conta == null) {
            throw new ContaNaoEncontradaException("Conta não encontrada.");
        }

        return conta;
    }

    public boolean cpfJaExiste(String cpf) {
        return contas.values()
                .stream()
                .anyMatch(conta -> conta.getCliente().getCpf().equals(cpf));
    }

    public void transferir(String origem, String destino, double valor) {

        if (origem.equals(destino)) {
            throw new IllegalArgumentException("Conta de origem e destino não podem ser iguais.");
        }

        Conta contaOrigem = buscarConta(origem);
        Conta contaDestino = buscarConta(destino);

        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void salvarDados() {
        repository.salvar(contas);
    }
}

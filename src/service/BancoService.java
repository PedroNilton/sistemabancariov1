package service;

import model.Conta;
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

    public void criarConta(Conta conta) {
        contas.put(conta.getNumero(), conta);
    }

    public Conta buscarConta(String numero) {

        Conta conta = contas.get(numero);

        if (conta == null) {
            throw new ContaNaoEncontradaException("Conta não encontrada.");
        }

        return conta;
    }

    public boolean CpfJaExiste(String cpf) {
        return contas.values()
                .stream()
                .anyMatch(conta -> conta.getCliente().getCpf().equals(cpf));
    }

    public void transferir(String origem, String destino, double valor) {

        Conta contaOrigem = buscarConta(origem);
        Conta contaDestino = buscarConta(destino);

        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void salvarDados() {
        repository.salvar(contas);
    }
}

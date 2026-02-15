package service;

import model.Account;
import repository.ContaRepository;
import exception.ContaNaoEncontradaException;

import java.util.Map;

public class BancoService {

    private final ContaRepository repository;
    private Map<String, Account> accounts;

    public BancoService(ContaRepository repository) {
        this.repository = repository;
        this.accounts = repository.load();
    }

    public void createAccounts(Account account) {
        accounts.put(account.getNumero(), account);
    }

    public Account searchAccount(Stirng numero) {
        Account account = accounts.get(numero);
        if (account == null) {
            throw new ContaNaoEncontradaException("Conta não encontrada");
        }
        return account;
    }

    public void transfer(String origin, String destination, double value) {

        Account accountOrigin = searchAccount(origin);
        Account accountDestination = searchAccount(destination);

        accountOrigin.withdraw(value);
        accountDestination.deposit(value);

    }

    public void saveData() {
        repository.save(accounts);
    }
}
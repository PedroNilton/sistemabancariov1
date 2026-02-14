

public class BancoService {

    private final ContaRepository repository;
    private Map<String, Account> accounts;

    public BancoService(ContaRepository repository) {
        this.repository = repository;
        this.accounts = repository.load();
    }

    public void createAccounts(account account) {
        contas.put(account.getNumero(), account);
    }

    public account searchAccount(Stirng numero) {
        Account account = accounts.get(numero);
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }

    public void tranfer(String origin, String destination, double value) {

        Account accountOrigin = searchAccount(origin);
        Account accountDestination = searchAccount(destination);

        accountOrigin.withdraw(value);
        accountDestination.deposit(value);

    }
}
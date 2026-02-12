

public class BancoService {

    private Map<String, account> accounts = new HashMap<>();

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

    public void
}
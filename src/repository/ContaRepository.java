

public inteface ContaRepository {

    void save (Map<String, Account> acounts);
    Map<String, Account> load();
}

package repository;

import java.util.Map;
import model.Account;

public interface ContaRepository {

    void save (Map<String, Account> acounts);

    Map<String, Account> load();
}
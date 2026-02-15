package repository;

import java.util.Map;
import model.Conta;

public interface ContaRepository {

    void salvar(Map<String, Conta> contas);

    Map<String, Conta> carregar();
}

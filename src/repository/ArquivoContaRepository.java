import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ArquivoContaRepository implements ContaRepository {

    private final String nomeArquivo = "conta.txt";

    @Override
    public void save(Map<String, Account> accounts) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

            for (Account account : accounts.values()) {

                writer.write(account.getNumber() + ";" +
                        account.getClient().getName() + ";" +
                        account.getClient().getCpf() + ";" +
                        account.getBalance());

                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Account> load() {

        Map<String, Account> accounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(";");

                String number = parts[0];
                String name = parts[1];
                String cpf = parts[2];
                double balance = Double.parseDouble(parts[3]);

                Client client = new Client(name, cpf);
                Account account = new CurrentAccount(number, client);

                account.setInitialBalance(balance);

                accounts.put(number, account);
            }

        } catch (IOException e) {
            System.out.println("Arquivo ainda não existe.");
        }

        return accounts;
    }
}

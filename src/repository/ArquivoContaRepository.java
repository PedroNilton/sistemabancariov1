import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ArquivoContaRepository implements ContaRepository {

    private final String nameArquivo = "conta.txt";

    @Override
    public void save(Map<String, Account> accounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameArquivo))) {

            for (Account account : accounts.values()) {
                writer.write(account.getNumber() + ; +
                             account.getClient.getName() + ; +
                             account.getClient.getCpf() + ; +
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

        try (BufferedReader reader = new BufferedReader(new FileReader(nameArquivo))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] partes = line.split(";");

                String number = partes[0];
                String nome = partes[1];
                String cpf = partes[2];
                String balance = Double.parseDouble(partes[3]);

                Client client = new Client (nome, cpf);
                Account account = new CurrentAccount (number, client);
                account.deposit (balance);

                account.put (number, account);
            }

        } catch (IOException e) {
            System.out.println("Arquivo ainda não existe");
        }

        return accounts;
    }
}


public class TesteConta {

    public static void main(String[] args) {

        Client client = new Client("Pedro", "123");
        Account account = new CurrentAccount("1", client);

        account.deposit(100);

        if (account.getBalance() == 100) {
            System.out.println("Teste de depósito passou");
        } else {
            System.out.println("Teste de depósito não passou");
        }

        account.withdraw(50);

        if (account.getBalance() == 50) {
            System.out.println("Teste de saque passou");
        } else {
            System.out.println("Teste de saque não passou");
        }
    }
}
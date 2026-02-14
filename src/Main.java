
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ContaRepository repository = new ArchiveAccountRepository();
        BancoService bank = new BancoService(repository);

        int option;

        do {
            System.out.println("\n1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Dados");
            System.out.println("6 - Sair");
            System.out.println("Escolha: ");

            option = sc.nextInt();

            switch(option) {

                case 1 -> {

                    sc.nextLine();

                    System.out.println("Name: ");
                    String name = sc.nextLine();

                    System.out.println("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.println("Number account: ");
                    String number = sc.nextLine();

                    Client client = new Client(name, cpf);
                    Account account = new CurrentAccount(number, client);

                    bank.createAccount(account);

                    System.out.println("Conta Criada com sucesso!");
                }

                case 2 -> {
                    System.out.println("Number account: ");
                    String number = sc.next();

                    System.out.println("Value: ");
                    double value = sc.nextDouble();

                    bank.searchAccount(number).deposit(value);

                    System.out.println("Depósito realizado");
                }

                case 3 -> {
                    System.out.println("Number account: ");
                    String number = sc.next();

                    System.out.println("Value: ");
                    double value = sc.nextDouble();

                    bank.searchAccount(number).withdraw(value);

                    System.out.println("Saque realizado!");
                }

                case 4 -> {
                    System.out.println("Origin account: ");
                    String number = sc.next();

                    System.out.println("Origin destination: ");
                    String destination = sc.next();

                    System.out.println("Value: ");
                    double value = sc.nextDouble();

                    bank.transfer(origin, destination, value);

                    System.out.println("Transferencia realizada com sucesso!");
                }

                case 5 -> {
                    bank.saveData();
                    System.out.println("Data salvo com sucesso!");

                }
                case 6 -> System.out.println("Encerrando. . . ");

                default -> System.out.println("Opção inválida");
                }

                }
            } while (option != 6);
    }
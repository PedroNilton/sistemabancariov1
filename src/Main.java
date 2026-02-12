
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BancoService bank = new BancoService();

        int option;

        do {
            System.out.println("\n1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Sair");
            System.out.println("Escolha: ");

            switch(option) {

                case 1 -> {
                    System.out.println("Name: ");
                    sc.nextLine();
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
                    String value = sc.nextDouble();

                    bank.searchAccount(number).deposit(value);

                    System.out.println("Depósito realizado");
                }

                case 3 -> {
                    System.out.println("Number account: ");
                    String number = sc.next();

                    System.out.println("Value: ");
                    String value = sc.nextDouble();

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

                case 5 -> System.out.println("Encerrando. . . ");

                default -> System.out.println("Opção inválida");
                }

            } while (option != 5);
        }
    }
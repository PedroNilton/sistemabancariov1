import model.*;
import repository.*;
import service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ContaRepository repository = new ArquivoContaRepository();
        BancoService bancoService = new BancoService(repository);
        ContaService contaService = new ContaService();

        int opcao;

        do {
            System.out.println("\n1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Salvar Dados");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1 -> {
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Número da conta: ");
                    String numero = sc.nextLine();

                    Cliente cliente = new Cliente(nome, cpf);
                    Conta conta = new ContaCorrente(numero, cliente);

                    bancoService.criarConta(conta);

                    System.out.println("Conta criada com sucesso!");
                }

                case 2 -> {
                    System.out.print("Número da conta: ");
                    String numero = sc.next();

                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();

                    Conta conta = bancoService.buscarConta(numero);
                    contaService.depositar(conta, valor);

                    System.out.println("Depósito realizado!");
                }

                case 3 -> {
                    System.out.print("Número da conta: ");
                    String numero = sc.next();

                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();

                    Conta conta = bancoService.buscarConta(numero);
                    contaService.sacar(conta, valor);

                    System.out.println("Saque realizado!");
                }

                case 4 -> {
                    System.out.print("Conta origem: ");
                    String origem = sc.next();

                    System.out.print("Conta destino: ");
                    String destino = sc.next();

                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();

                    bancoService.transferir(origem, destino, valor);

                    System.out.println("Transferência realizada com sucesso!");
                }

                case 5 -> {
                    bancoService.salvarDados();
                    System.out.println("Dados salvos com sucesso!");
                }

                case 6 -> {
                    bancoService.salvarDados();
                    System.out.println("Encerrando...");
                }

                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 6);

        sc.close();
    }
}

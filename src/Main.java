import exception.ContaNaoEncontradaException;
import exception.SaldoInsuficienteException;
import model.*;
import repository.*;
import service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //cria as dependências
        ContaRepository repository = new ArquivoContaRepository();
        BancoService bancoService = new BancoService(repository);
        ContaService contaService = new ContaService();

        int opcao;

        do {
            System.out.println("\n1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Ver Extrato");
            System.out.println("6 - Salvar Dados");
            System.out.println("7 - Sair");
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
                    try {

                    System.out.print("Número da conta: ");
                    String numero = sc.next();

                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();

                    Conta conta = bancoService.buscarConta(numero);
                    contaService.depositar(conta, valor);

                    System.out.println("Depósito realizado!");

                } catch (ContaNaoEncontradaException e) {
                    System.out.println("Conta não encontrada!");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

                case 3 -> {

                    try {
                        System.out.print("Número da conta: ");
                        String numero = sc.next();

                        System.out.print("Valor: ");
                        double valor = sc.nextDouble();

                        Conta conta = bancoService.buscarConta(numero);
                        contaService.sacar(conta, valor);

                        System.out.println("Saque realizado!");
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("Saldo insuficiente!");
                    } catch (ContaNaoEncontradaException e) {
                        System.out.println("Conta não encontrada!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 4 -> {

                    try {
                        System.out.print("Conta origem: ");
                        String origem = sc.next();

                        System.out.print("Conta destino: ");
                        String destino = sc.next();

                        System.out.print("Valor: ");
                        double valor = sc.nextDouble();

                        bancoService.transferir(origem, destino, valor);

                        System.out.println("Transferência realizada com sucesso!");
                    } catch (ContaNaoEncontradaException e) {
                        System.out.println("Conta não encontrada!");
                    } catch (SaldoInsuficienteException e) {
                        System.out.println("Saldo insuficiente!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 5 -> {
                    System.out.println("Número da conta: ");
                    String numero = sc.next();

                    try {
                        Conta conta = bancoService.buscarConta(numero);
                        contaService.extrato(conta);
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 6 -> {
                    bancoService.salvarDados();
                    System.out.println("Dados salvos com sucesso!");
                }

                case 7 -> {
                    bancoService.salvarDados();
                    System.out.println("Encerrando...");
                }

                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 7);

        sc.close();
    }
}

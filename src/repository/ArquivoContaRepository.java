package repository;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ArquivoContaRepository implements ContaRepository {

    private final String nomeArquivo = "contas.txt";

    @Override
    public void salvar(Map<String, Conta> contas) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

            for (Conta conta : contas.values()) {

                writer.write(conta.getNumero() + ";" +
                        conta.getCliente().getNome() + ";" +
                        conta.getCliente().getCpf() + ";" +
                        conta.getSaldo());

                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Conta> carregar() {

        Map<String, Conta> contas = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                String numero = partes[0];
                String nome = partes[1];
                String cpf = partes[2];
                double saldo = Double.parseDouble(partes[3]);

                Cliente cliente = new Cliente(nome, cpf);
                Conta conta = new ContaCorrente(numero, cliente);

                conta.definirSaldoInicial(saldo);

                contas.put(numero, conta);
            }

        } catch (IOException e) {
            System.out.println("Arquivo ainda não existe.");
        }

        return contas;
    }
}

package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        DbConnection conexao = new DbConnection();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

       Connection connection = conexao.getConnect();

        System.out.println("Bem vindo! Selecione uma opção");
        System.out.println("1. Cadastrar pessoa");
        System.out.println("2. Atualizar uma pessoa");
        System.out.println("3. Deletar uma pessoa");
        System.out.println("4. Pesquisar por nome");
        System.out.println("5. Sair");

        while (continuar) {
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarPessoa(pessoaDAO, scanner);
                    break;
                case 2:
                    atualizarPessoa(pessoaDAO, scanner);
                    break;
                case 3:
                    deletarPessoa(pessoaDAO, scanner);
                    break;
                case 4:
                    pesquisarPorNome(pessoaDAO, scanner);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }

        pessoaDAO.close();
        scanner.close();
        System.out.println("Encerrando o programa.");
    }

    private static void cadastrarPessoa(PessoaDAO pessoaDAO, Scanner scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.next();
        System.out.println("Digite o email:");
        String email = scanner.next();
        Pessoa pessoa = new Pessoa(email, nome);
        pessoaDAO.cadastrarPessoa(pessoa);
    }

    private static void atualizarPessoa(PessoaDAO pessoaDAO, Scanner scanner) {
        System.out.println("Digite o email da pessoa que deseja atualizar:");
        String email = scanner.next();
        System.out.println("Digite o novo nome:");
        String nome = scanner.next();
        Pessoa pessoa = new Pessoa(email, nome);
        pessoaDAO.atualizarPessoa(pessoa);
    }

    private static void deletarPessoa(PessoaDAO pessoaDAO, Scanner scanner) {
        System.out.println("Digite o email da pessoa que deseja deletar:");
        String email = scanner.next();
        pessoaDAO.deletarPessoa(email);
    }

    private static void pesquisarPorNome(PessoaDAO pessoaDAO, Scanner scanner) {
        System.out.println("Digite o nome que deseja pesquisar:");
        String nome = scanner.next();
        System.out.println("Pessoas encontradas:");
        pessoaDAO.pesquisarPessoasPorNome(nome).forEach(p -> System.out.println("Nome: " + p.getNome() + ", Email: " + p.getEmail()));
    }
}


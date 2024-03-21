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

        GestaoPessoas gestaoPessoas = new GestaoPessoas(pessoaDAO, scanner);
        
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
                    gestaoPessoas.cadastrarPessoa();
                    break;
                case 2:
                    gestaoPessoas.atualizarPessoa();
                    break;
                case 3:
                    gestaoPessoas.deletarPessoa();
                    break;
                case 4:
                    gestaoPessoas.pesquisarPorNome();
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
}


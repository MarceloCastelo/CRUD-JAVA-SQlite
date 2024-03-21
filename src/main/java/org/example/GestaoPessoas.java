package org.example;

import java.util.Scanner;

public class GestaoPessoas {
    private PessoaDAO pessoaDAO;
    private Scanner scanner;

    public GestaoPessoas(PessoaDAO pessoaDAO, Scanner scanner) {
        this.pessoaDAO = pessoaDAO;
        this.scanner = scanner;
    }

    public void cadastrarPessoa() {
        System.out.println("Digite o nome:");
        String nome = scanner.next();
        System.out.println("Digite o email:");
        String email = scanner.next();
        Pessoa pessoa = new Pessoa(email, nome);
        pessoaDAO.cadastrarPessoa(pessoa);
    }

    public void atualizarPessoa() {
        System.out.println("Digite o email da pessoa que deseja atualizar:");
        String email = scanner.next();
        System.out.println("Digite o novo nome:");
        String nome = scanner.next();
        Pessoa pessoa = new Pessoa(email, nome);
        pessoaDAO.atualizarPessoa(pessoa);
    }

    public void deletarPessoa() {
        System.out.println("Digite o email da pessoa que deseja deletar:");
        String email = scanner.next();
        pessoaDAO.deletarPessoa(email);
    }

    public void pesquisarPorNome() {
        System.out.println("Digite o nome que deseja pesquisar:");
        String nome = scanner.next();
        System.out.println("Pessoas encontradas:");
        pessoaDAO.pesquisarPessoasPorNome(nome).forEach(p -> System.out.println("Nome: " + p.getNome() + ", Email: " + p.getEmail()));
    }
}

package org.example;

import java.util.List;

public interface IPessoaDAO {

    void close();

    void cadastrarPessoa(Pessoa pessoa);

    void atualizarPessoa(Pessoa pessoa);

    void deletarPessoa(String email);

    List<Pessoa> pesquisarPessoasPorNome(String nome);
}

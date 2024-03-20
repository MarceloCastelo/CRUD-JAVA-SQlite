package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private Connection connection;

    public PessoaDAO() {
        this.connection = DbConnection.connect();
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexão com o banco de dados fechada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoas(email, nome) VALUES(?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getEmail());
            stmt.setString(2, pessoa.getNome());
            stmt.executeUpdate();
            System.out.println("Pessoa cadastrada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar pessoa: " + e.getMessage());
        }
    }

    public void atualizarPessoa(Pessoa pessoa) {
        String sql = "UPDATE pessoas SET nome = ? WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pessoa atualizada com sucesso.");
            } else {
                System.out.println("Nenhuma pessoa encontrada com o email especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }

    public void deletarPessoa(String email) {
        String sql = "DELETE FROM pessoas WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pessoa deletada com sucesso.");
            } else {
                System.out.println("Nenhuma pessoa encontrada com o email especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar pessoa: " + e.getMessage());
        }
    }

    public List<Pessoa> pesquisarPessoasPorNome(String nome) {
        List<Pessoa> pessoasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String nomePessoa = rs.getString("nome");
                Pessoa pessoa = new Pessoa(email, nomePessoa);
                pessoasEncontradas.add(pessoa);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar pessoas por nome: " + e.getMessage());
        }
        return pessoasEncontradas;
    }
}

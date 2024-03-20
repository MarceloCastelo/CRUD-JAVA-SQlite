package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection connect() {

        Connection conn = null;

        try {
            // JDBC URL para o banco de dados SQLite

            String url = "jdbc:sqlite:crudjava.db"; // Altere para o caminho do seu banco de dados
            // Estabelecendo conexão com o banco de dados

            conn = DriverManager.getConnection(url);

            System.out.println("Conexão com o SQLite estabelecida.");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return conn;
    }
}

package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection implements IConexao {

    @Override
    public Connection getConnect() {

        Connection conn = null;

        try {

            String url = "jdbc:sqlite:crudjava.db";

            conn = DriverManager.getConnection(url);

            System.out.println("Conexão com o SQLite estabelecida.");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        return conn;
    }

}

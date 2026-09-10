package br.com.cp1.crudfilmes.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

    private static Connection connection;

    private ConnectionSingleton() {
    }

    public static Connection getConnection() {

        if (connection == null) {

            try {
                String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
                String usuario = "RM563490";
                String senha = "290506";

                connection = DriverManager.getConnection(url, usuario, senha);

                System.out.println("Conexao realizada com sucesso!");

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao conectar com o banco de dados.", e);
            }
        }

        return connection;
    }
}
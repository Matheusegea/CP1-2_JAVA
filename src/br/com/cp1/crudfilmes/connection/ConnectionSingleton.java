package br.com.cp1.crudfilmes.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionSingleton {

    private static Connection connection;

    private ConnectionSingleton() {
    }

    public static Connection getConnection() {

        if (connection == null) {

            try {
                Properties properties = new Properties();

                FileInputStream arquivo = new FileInputStream("config.properties");
                properties.load(arquivo);

                String url = properties.getProperty("oracle.url");
                String usuario = properties.getProperty("oracle.user");
                String senha = properties.getProperty("oracle.password");

                connection = DriverManager.getConnection(url, usuario, senha);

                System.out.println("Conexao realizada com sucesso!");

            } catch (IOException | SQLException e) {
                throw new RuntimeException("Erro ao conectar com o banco de dados.", e);
            }
        }

        return connection;
    }
}
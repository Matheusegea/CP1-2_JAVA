package br.com.cp1.crudfilmes.factory;

import br.com.cp1.crudfilmes.connection.ConnectionSingleton;
import br.com.cp1.crudfilmes.dao.FilmeDAO;
import br.com.cp1.crudfilmes.dao.FilmeDAOImpl;

public class FactoryDAO {

    public static FilmeDAO criarFilmeDAO() {
        return new FilmeDAOImpl(ConnectionSingleton.getConnection());
    }
}
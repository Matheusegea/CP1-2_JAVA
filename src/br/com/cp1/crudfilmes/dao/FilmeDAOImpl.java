package br.com.cp1.crudfilmes.dao;

import br.com.cp1.crudfilmes.model.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAOImpl implements FilmeDAO {

    private Connection connection;

    public FilmeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvar(Filme filme) {

        String sql = "INSERT INTO FILMES (TITULO, DIRETOR, ANO_LANCAMENTO, GENERO) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getDiretor());
            stmt.setInt(3, filme.getAnoLancamento());
            stmt.setString(4, filme.getGenero());

            stmt.executeUpdate();

            System.out.println("Filme salvo com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar filme.", e);
        }
    }

    @Override
    public Filme buscarPorId(int id) {

        String sql = "SELECT * FROM FILMES WHERE ID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Filme(
                        rs.getInt("ID"),
                        rs.getString("TITULO"),
                        rs.getString("DIRETOR"),
                        rs.getInt("ANO_LANCAMENTO"),
                        rs.getString("GENERO")
                );
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar filme.", e);
        }
    }

    @Override
    public List<Filme> listarTodos() {

        String sql = "SELECT * FROM FILMES ORDER BY ID";

        List<Filme> filmes = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Filme filme = new Filme(
                        rs.getInt("ID"),
                        rs.getString("TITULO"),
                        rs.getString("DIRETOR"),
                        rs.getInt("ANO_LANCAMENTO"),
                        rs.getString("GENERO")
                );

                filmes.add(filme);
            }

            return filmes;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar filmes.", e);
        }
    }

    @Override
    public void atualizar(Filme filme) {

        String sql = "UPDATE FILMES SET TITULO = ?, DIRETOR = ?, ANO_LANCAMENTO = ?, GENERO = ? WHERE ID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getDiretor());
            stmt.setInt(3, filme.getAnoLancamento());
            stmt.setString(4, filme.getGenero());
            stmt.setInt(5, filme.getId());

            stmt.executeUpdate();

            System.out.println("Filme atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar filme.", e);
        }
    }

    @Override
    public void deletar(int id) {

        String sql = "DELETE FROM FILMES WHERE ID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Filme deletado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar filme.", e);
        }
    }
}
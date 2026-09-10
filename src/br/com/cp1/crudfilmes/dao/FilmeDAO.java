package br.com.cp1.crudfilmes.dao;

import br.com.cp1.crudfilmes.model.Filme;

import java.util.List;

public interface FilmeDAO {

    void salvar(Filme filme);

    Filme buscarPorId(int id);

    List<Filme> listarTodos();

    void atualizar(Filme filme);

    void deletar(int id);
}
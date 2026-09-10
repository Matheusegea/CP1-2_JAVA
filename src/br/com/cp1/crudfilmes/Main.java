package br.com.cp1.crudfilmes;

import br.com.cp1.crudfilmes.dao.FilmeDAO;
import br.com.cp1.crudfilmes.factory.FactoryDAO;
import br.com.cp1.crudfilmes.model.Filme;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FilmeDAO dao = FactoryDAO.criarFilmeDAO();

        int opcao;

        do {

            System.out.println("\nCRUD DE FILMES");
            System.out.println("\n1 - Cadastrar filme");
            System.out.println("2 - Listar filmes");
            System.out.println("3 - Buscar filme por ID");
            System.out.println("4 - Atualizar filme");
            System.out.println("5 - Deletar filme");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Digite o titulo: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite o diretor: ");
                    String diretor = scanner.nextLine();

                    System.out.print("Digite o ano de lancamento: ");
                    int anoLancamento = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o genero: ");
                    String genero = scanner.nextLine();

                    Filme filme = new Filme(
                            titulo,
                            diretor,
                            anoLancamento,
                            genero
                    );

                    dao.salvar(filme);

                    break;

                case 2:

                    List<Filme> filmes = dao.listarTodos();

                    System.out.println("\n===== FILMES CADASTRADOS =====");

                    if (filmes.isEmpty()) {
                        System.out.println("Nenhum filme cadastrado.");
                    } else {
                        for (Filme f : filmes) {
                            System.out.println(f);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Digite o ID do filme: ");
                    int idBusca = scanner.nextInt();

                    Filme filmeEncontrado = dao.buscarPorId(idBusca);

                    if (filmeEncontrado != null) {
                        System.out.println("\nFilme encontrado:");
                        System.out.println(filmeEncontrado);
                    } else {
                        System.out.println("Filme nao encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("Digite o ID do filme que deseja atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    Filme filmeAtualizar = dao.buscarPorId(idAtualizar);

                    if (filmeAtualizar != null) {

                        System.out.print("Digite o novo titulo: ");
                        filmeAtualizar.setTitulo(scanner.nextLine());

                        System.out.print("Digite o novo diretor: ");
                        filmeAtualizar.setDiretor(scanner.nextLine());

                        System.out.print("Digite o novo ano de lancamento: ");
                        filmeAtualizar.setAnoLancamento(scanner.nextInt());
                        scanner.nextLine();

                        System.out.print("Digite o novo genero: ");
                        filmeAtualizar.setGenero(scanner.nextLine());

                        dao.atualizar(filmeAtualizar);

                    } else {
                        System.out.println("Filme nao encontrado.");
                    }

                    break;

                case 5:

                    System.out.print("Digite o ID do filme que deseja deletar: ");
                    int idDeletar = scanner.nextInt();

                    Filme filmeDeletar = dao.buscarPorId(idDeletar);

                    if (filmeDeletar != null) {
                        dao.deletar(idDeletar);
                    } else {
                        System.out.println("Filme nao encontrado.");
                    }

                    break;

                case 0:

                    System.out.println("Programa encerrado.");

                    break;

                default:

                    System.out.println("Opcao invalida.");

                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}